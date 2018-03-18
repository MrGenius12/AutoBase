package ua.nure.serikov.SummaryTask4.web.command.driver;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBean;
import ua.nure.serikov.SummaryTask4.db.bean.RequestUserBean;
import ua.nure.serikov.SummaryTask4.db.entity.User;
import ua.nure.serikov.SummaryTask4.exception.AppException;
import ua.nure.serikov.SummaryTask4.web.UtilsWeb;
import ua.nure.serikov.SummaryTask4.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *AutoBase
 *
 * @author Serikov Eugene
 */

/**
 * Driver personal office
 */
public class DriverPersonalCommand extends Command {

    private static final Logger LOG = Logger.getLogger(DriverPersonalCommand.class);

    private final DBManager dbManager;

    public DriverPersonalCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Driver personal office command starts");
        // the default path of transition in case of success
        String forward = Path.PAGE_DRIVER_PERSONAL;

        // get this session
        HttpSession session = request.getSession();

        //delete "OkMessage" from session
        UtilsWeb.removeUnwantedAttributeOkMessageFromSession(session, request);
        LOG.trace("delete \"OkMessage\" from session");

        // get attribute user
        User user = (User) session.getAttribute("user");
        LOG.trace("get attribute user: " + user);

        // check "user". If is null - throw exception
        if (user != null) {
            // get all trips from driver (status must be "OPEN")
            List<TripUserTruckBean> allTripsFromDriverId = dbManager.getAllTripFromDriverId(user.getId());
            LOG.trace("Found in DB: all trips from driver : " + allTripsFromDriverId);

            // put all trips from driver to request
            session.setAttribute("allTrips", allTripsFromDriverId);
            LOG.trace("Set the request attribute: all Trips From Driver : " + allTripsFromDriverId);


            // get all requests from the database
            List<RequestUserBean> allRequests = dbManager.getAllRequestsFromDriver(user.getId());
            LOG.trace("Found in DB: allRequests --> " + allRequests);

            // put user order beans list to request
            session.setAttribute("allRequests", allRequests);
            LOG.trace("Set the request attribute: allRequests");

        } else {
            LOG.error("Incorrect parameter user!");
            throw new AppException("Incorrect parameter user! Please login again");
        }

        LOG.debug("Driver personal office command finished");
        return forward;
    }
}