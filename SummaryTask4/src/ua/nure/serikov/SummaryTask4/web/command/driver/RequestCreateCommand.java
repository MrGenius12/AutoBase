package ua.nure.serikov.SummaryTask4.web.command.driver;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.entity.Trip;
import ua.nure.serikov.SummaryTask4.db.entity.Request;
import ua.nure.serikov.SummaryTask4.db.entity.User;
import ua.nure.serikov.SummaryTask4.db.util.ValidUtils;
import ua.nure.serikov.SummaryTask4.exception.AppException;
import ua.nure.serikov.SummaryTask4.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.serikov.SummaryTask4.db.util.ValidUtils.inputValidCharacteristicTruck;
import static ua.nure.serikov.SummaryTask4.db.util.ValidUtils.isBoolean;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

/**
 * Request create
 */
public class RequestCreateCommand extends Command {

    private static final Logger LOG = Logger.getLogger(RequestCreateCommand.class);

    private final DBManager dbManager;

    public RequestCreateCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Request create command starts");
        // the default path of transition in case of success
        String forward = Path.PAGE_REQUEST_CREATE;

        // get this session
        HttpSession session = request.getSession();

        // insert in the database flag
        String insertToBD = request.getParameter("insertToBD");

        // validation checks parameters to insert to BD
        if (insertToBD != null && insertToBD.equals("insertToBD")) {
            LOG.trace("Flag of insert to BD.");

            // get attribute user
            User user = (User) session.getAttribute("user");
            LOG.trace("get attribute user: " + user);
            // get attribute tripId
            String tripId = (String) session.getAttribute("tripId");
            LOG.trace("get attribute tripId: " + tripId);
            // get parameter carrying
            String carrying = request.getParameter("carrying");
            LOG.trace("parameter of carrying: " + carrying);
            // get parameter capacity
            String capacity = request.getParameter("capacity");
            LOG.trace("parameter of capacity: " + capacity);
            // get parameter length
            String length = request.getParameter("length");
            LOG.trace("parameter of length: " + length);
            // get parameter lorryWithSides
            String lorryWithSides = request.getParameter("lorryWithSides");
            LOG.trace("parameter of lorryWithSides: " + lorryWithSides);
            // get parameter refrigerator
            String refrigerator = request.getParameter("refrigerator");
            LOG.trace("parameter of refrigerator: " + refrigerator);

            String validationCharacteristicTruck = inputValidCharacteristicTruck(carrying, capacity, length);

            // validation checks parameters user and tripId. If not - throw exception
            if (user != null && ValidUtils.isNumber(tripId) && validationCharacteristicTruck.equals("ok") &&
                    (isBoolean(lorryWithSides, refrigerator, "true"))) {
                LOG.debug("input parameters user form validation - ok");

                Request requestInBD = new Request();

                // set trip Id
                requestInBD.setTripId(Integer.valueOf(tripId));
                // set carrying, if the user enters values
                if (carrying != null && !carrying.equals("")) {
                    requestInBD.setCarrying(Double.valueOf(carrying));
                }
                // set capacity, if the user enters values
                if (capacity != null && !capacity.equals("")) {
                    requestInBD.setCapacity(Double.valueOf(capacity));
                }
                // set length, if the user enters values
                if (length != null && !length.equals("")) {
                    requestInBD.setLength(Double.valueOf(length));
                }
                // set lorryWithSides
                requestInBD.setLorryWithSides(Boolean.valueOf(lorryWithSides));
                // set refrigerator
                requestInBD.setRefrigerator(Boolean.valueOf(refrigerator));
                // set user id
                requestInBD.setDriverId(user.getId());

                LOG.debug("prepared request input in DB: " + requestInBD);

                // insert "request" in the BD
                // successfulExecutionUpdate - successful execution must be 1
                int successfulExecutionAdd = dbManager.insertRequest(requestInBD);
                LOG.debug("insert request in DB. Successful execution must be 1 --> " + successfulExecutionAdd);

                // put "okMessage" to request
                session.setAttribute("okMessage", "okMessageRequestCreate");
                LOG.trace("Set the request attribute: okMessage --> " + "okMessageRequestCreate");

                // path of transition in case of success
                forward = Path.COMMAND_LIST_TRIPS;

            } else {
                LOG.error("parameters user/tripId or characteristic truck incorrect! Characteristic - "
                        + validationCharacteristicTruck);
                throw new AppException("parameters user/tripId or characteristic truck incorrect! Characteristic - "
                        + validationCharacteristicTruck);
            }
        } else {
            // get Attribute allTrips.
            List<Trip> allTrips = (ArrayList<Trip>) session.getAttribute("allTrips");
            LOG.trace("get attribute allTrips: " + allTrips);

            // get parameter idTrip
            String idTrip = request.getParameter("idTrip");
            LOG.trace("get attribute idTrip: " + idTrip);

            //  validation checks parameters allTrips and idTrip. They  should not be NULL
            if (allTrips != null && idTrip != null) {

                LOG.trace("validation checks parameters allTrips and idTrip: not NULL ");

                // find trip for id of all trips
                for (Trip trip : allTrips) {
                    if (trip.getId() == Integer.valueOf(idTrip)) {

                        // set trip in attribute "requestTrip".
                        session.setAttribute("requestTrip", trip);
                        LOG.trace("set attribute requestTrip: " + trip);

                        // set id from trip in attribute "requestTrip".
                        session.setAttribute("tripId", idTrip);
                        LOG.trace("set attribute tripId: " + idTrip);

                        break;
                    }
                }
            }
        }

        LOG.debug("Request create command finished");
        return forward;
    }
}