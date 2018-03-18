package ua.nure.serikov.SummaryTask4.web.command.admin;

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
 * Trip user.
 */

public class DeleteTripCommand extends Command {

    private static final Logger LOG = Logger.getLogger(DeleteTripCommand.class);

    private final DBManager dbManager;

    public DeleteTripCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Delete trip command starts");
        // the default path of transition in case of success
        String forward = Path.COMMAND_LIST_TRIPS;

        // get this session
        HttpSession session = request.getSession();

        // the id trip to be removed
        String deleteTripId = request.getParameter("deleteTripId");
        LOG.debug("Delete trip by id: " + deleteTripId);

        // validation checks parameters. If not - throw exception
        if (deleteTripId != null && !deleteTripId.equals("") && ValidUtils.isNumber(deleteTripId)) {
            LOG.trace("parameter of id trip correct");

            // delete trip from id.
            // successfulExecutionUpdate - successful execution must be 1
            int successfulExecutionDelete = dbManager.deleteTrip(Integer.valueOf(deleteTripId));

            LOG.trace("delete trip in DB: successful execution must be 1 --> " + successfulExecutionDelete);

            //  put "okMessage" to request
            session.setAttribute("okMessage", "okMessage");
            LOG.trace("Set the request attribute: okMessage --> " + "okMessage");

        } else {
            LOG.error("No parameter of id trip, or incorrect!");
            throw new AppException("Cannot delete trip! Incorrect id parameter.");
        }

        LOG.debug("Delete trip command finished");
        return forward;
    }
}