package ua.nure.serikov.SummaryTask4.web.command.driver;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.util.ValidUtils;
import ua.nure.serikov.SummaryTask4.exception.AppException;
import ua.nure.serikov.SummaryTask4.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

/**
 * Trip completed
 */
public class TripCompletedCommand extends Command {

    private static final Logger LOG = Logger.getLogger(TripCompletedCommand.class);

    private final DBManager dbManager;

    public TripCompletedCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Trip completed command starts");
        // the default path of transition
        String forward = Path.PAGE_ERROR;

        // get this session
        HttpSession session = request.getSession();

        // insert in the database flag
        String insertToBD = request.getParameter("insertToBD");

        // validation checks parameters to insert to BD
        if (insertToBD != null && insertToBD.equals("insertToBD")) {
            LOG.trace("Flag of insert to BD.");

            // get parameter tripId
            String tripId = request.getParameter("tripId");
            LOG.debug("parameter of tripId: " + tripId);
            // get parameter truckId
            String truckId = request.getParameter("truckId");
            LOG.debug("parameter of truckId: " + truckId);
            // get parameter isTruckServiceable
            String isTruckServiceable = request.getParameter("isTruckServiceable");
            LOG.debug("parameter of isTruckServiceable: " + isTruckServiceable);

            // validation checks parameters approveRequestTruckId - is a number. If not - throw exception
            if (ValidUtils.isNumber(tripId) && ValidUtils.isNumber(truckId) &&
                    ValidUtils.isBoolean(isTruckServiceable)) {

                LOG.trace("input parameters correct!");

                // update trip (Completed).From trip id, truck id. Set truck serviceable.
                // successfulExecutionUpdate - successful execution must be 1
                int successfulExecution = dbManager.updateTripCompleted(
                        Integer.valueOf(tripId), Integer.valueOf(truckId), Boolean.valueOf(isTruckServiceable));
                LOG.trace("Update trip completed in DB: successful execution must be 1 --> " + successfulExecution);

                // put "okMessage" to request
                session.setAttribute("okMessage", "okMessageTripCompleted");
                LOG.trace("Set the request attribute: okMessage --> " + "okMessageTripCompleted");

                forward = Path.COMMAND_DRIVER_PERSONAL;

            } else {
                LOG.error("input parameters incorrect!");
                throw new AppException("input parameters incorrect!");
            }
        }

        LOG.debug("Trip completed Command finished");
        return forward;
    }
}