package ua.nure.serikov.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.Role;
import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBean;
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
import java.util.List;

/**
 * Lists trips.
 */
public class ListTripsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ListTripsCommand.class);

    private final DBManager dbManager;

    public ListTripsCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * Serializable comparator used with TreeMap container. When the servlet
     * container tries to serialize the session it may fail because the session
     * can contain TreeMap object with not serializable comparator.
     */

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Commands List trips starts");
        // the default path of transition in case of success
        String forward = Path.PAGE_LIST_TRIPS;

        // get this session
        HttpSession session = request.getSession();

        //delete "OkMessage" from session
        UtilsWeb.removeUnwantedAttributeOkMessageFromSession(session, request);
        LOG.trace("delete \"OkMessage\" from session");

        //get user from session
        User user = (User) session.getAttribute("user");
        LOG.trace("Get Attribute user --> " + user);

        //check valid user
        if (user == null) {
            LOG.error("User do not have permission to access the requested resource");
            throw new AppException("You do not have permission to access the requested resource.");
        }

        if (Role.getRole(user) == Role.DRIVER) {

            LOG.debug("Role: " + Role.getRole(user));

            // the default path of transition in case of success (driver)
            forward = Path.PAGE_LIST_TRIPS_DRIVER;

            List<Trip> allTrips = dbManager.getAllTripsFromDriver(user.getId());
            LOG.trace("Found trips from DRIVER, status OPEN: " + allTrips);

            // put allTrips list to request
            session.setAttribute("allTrips", allTrips);
            LOG.trace("Set the request attribute: all Trips");

        } else if ((Role.getRole(user) == Role.ADMIN) || (Role.getRole(user) == Role.DISPATCHER)) {

            LOG.debug("Role: " + Role.getRole(user));

            // Found trips from DISPATCHER or ADMIN
            List<TripUserTruckBean> allTrips = dbManager.getAllTrip();
            LOG.trace("Found trips in DB from " + Role.getRole(user) + ": TripUserTruckBean --> " + allTrips);

            // put allTrips list to request
            session.setAttribute("allTrips", allTrips);
            LOG.trace("Set the request attribute: all Trips");

            // get parameter approve
            String approve = request.getParameter("approve");
            System.out.println(approve);
            LOG.trace("Request parameter approve: " + approve);

            if(approve!= null && approve.equals("approve")){
                // the default path of transition in case of success
                forward = Path.PAGE_LIST_TRIPS_APPROVE;
                LOG.trace("forward approve list trips");
            }

        } else {

            LOG.error("User do not have permission to access the requested resource");
            throw new AppException("You do not have permission to access the requested resource.");
        }

        LOG.debug("Commands list trips finished");
        return forward;
    }
}