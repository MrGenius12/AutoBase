package ua.nure.serikov.SummaryTask4.web.command.dispatcher;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.entity.Trip;
import ua.nure.serikov.SummaryTask4.db.entity.User;
import ua.nure.serikov.SummaryTask4.exception.AppException;
import ua.nure.serikov.SummaryTask4.web.UtilsWeb;
import ua.nure.serikov.SummaryTask4.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import static ua.nure.serikov.SummaryTask4.db.util.ValidUtils.inputValidTripCreate;
import static ua.nure.serikov.SummaryTask4.db.util.ValidUtils.isBoolean;

/**
 *AutoBase
 *
 * @author Serikov Eugene
 */

/**
 * Trip create
 */
public class TripCreateCommand extends Command {

    private static final Logger LOG = Logger.getLogger(TripCreateCommand.class);

    private final DBManager dbManager;

    public TripCreateCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Trip create command starts");
        // the default path of transition in case of success
        String forward = Path.PAGE_TRIP_CREATE;

        // get this session
        HttpSession session = request.getSession();

        // get user from session
        User user = (User) session.getAttribute("user");
        LOG.debug("Get Attribute user: " + user);

        //check valid user
        if (user == null) {
            LOG.error("User do not have permission to access the requested resource");
            throw new AppException("You do not have permission to access the requested resource.");
        }

        // insert in the database flag
        String insertToBD = request.getParameter("insertToBD");

        // validation checks parameters to insert to BD
        if (insertToBD != null && insertToBD.equals("insertToBD")) {
            LOG.trace("Flag of insert to BD.");

            // get parameter tripNumber
            String tripNumber = request.getParameter("tripNumber");
            LOG.debug("parameter of tripNumber: " + tripNumber);
            // get parameter dateDeparture
            String dateDeparture = request.getParameter("dateDeparture");
            LOG.debug("parameter of dateDeparture: " + dateDeparture);
            // get parameter destination
            String destination = request.getParameter("destination");
            LOG.debug("parameter of destination: " + destination);
            // get parameter distance
            String distance = request.getParameter("distance");
            LOG.debug("parameter of distance: " + distance);

            String validationParametersTrip =
                    inputValidTripCreate(tripNumber, dateDeparture, destination, distance);

            // validation checks parameters trip. If not - throw exception
            if (validationParametersTrip.equals("ok")) {
                LOG.debug("input parameters trip form validation - ok");

                Trip trip = new Trip();
                // get this date
                Date sqlStartDate = new Date(new java.util.Date().getTime());

                // set tripNumber
                trip.setTripNumber(Integer.parseInt(tripNumber));
                // set date creation
                trip.setDateCreation(sqlStartDate);
                // set date departure, if the user enters values
                if (dateDeparture != null && !dateDeparture.equals("")) {
                    trip.setDateDeparture(Date.valueOf(dateDeparture));
                }
                // set destination, if the user enters values
                if (destination != null && !destination.equals("")) {
                    trip.setDestination(destination);
                }
                // set distance, if the user enters values
                if (distance != null && !distance.equals("")) {
                    trip.setDistance(Double.valueOf(distance));
                }

                LOG.debug("prepared trip input in DB: " + trip);

                // create trip.
                // successfulExecutionUpdate - successful execution must be 1
                int successfulExecutionAdd = dbManager.insertTrip(trip, user.getId());

                LOG.debug("insert trip in DB. Successful execution must be 1 --> " + successfulExecutionAdd);

                // put "okMessage" to request
                session.setAttribute("okMessage", "okMessageTripCreate");
                LOG.trace("Set the request attribute: okMessage --> " + "okMessageTripCreate");

                // get parameter sendMail
                String sendMail = request.getParameter("sendMail");
                LOG.debug("parameter of sendMail: " + sendMail);

                //if sendMail true - send to drivers
                if (sendMail != null && isBoolean(sendMail) && Boolean.valueOf(sendMail)) {

                    // get all emails of DRIVER in BD
                    // put emails to List
                    List<String> emails = dbManager.getAllEmails();
                    LOG.trace("Found emails of DRIVER in BD " + emails);


                    // create new message by drivers
                    StringBuilder message = new StringBuilder();

                    // put title in message
                    message.append("Hello! In system a new trip. \n\nInfo about trip:");
                    // put trip in message
                    message.append("\ntrip number: ");
                    message.append(trip.getTripNumber());
                    // put date creation in message
                    message.append("\ndate creation: ");
                    message.append(trip.getDateCreation());
                    // put date departure in message
                    message.append("\ndate departure: ");
                    message.append(trip.getDateDeparture());
                    // put destination in message
                    message.append("\ndestination: ");
                    message.append(trip.getDestination());
                    // put distance in message
                    message.append("\ndistance: ");
                    message.append(trip.getDistance());
                    message.append("\nХорошего дня!");

                    LOG.debug("Create new message by drivers: " + message);

                    //send new trip to drivers e-mail
                    UtilsWeb.sendMail(message.toString(), UtilsWeb.SUBJECT_NEW_TRIP, emails);

                }

                // path of transition in case of success
                forward = Path.COMMAND_LIST_TRIPS;

            } else {
                LOG.error("input parameters of trip form incorrect! --> " + validationParametersTrip);
                throw new AppException("input parameters of trip form incorrect! " + validationParametersTrip);
            }
        }

        LOG.debug("Trip create command finished");
        return forward;
    }
}