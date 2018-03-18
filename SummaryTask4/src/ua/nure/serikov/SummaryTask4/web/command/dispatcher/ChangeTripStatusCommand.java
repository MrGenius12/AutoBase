package ua.nure.serikov.SummaryTask4.web.command.dispatcher;

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
 *AutoBase
 *
 * @author Serikov Eugene
 */

/**
 * Update trip status
 */

public class ChangeTripStatusCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ChangeTripStatusCommand.class);

    private final DBManager dbManager;

    public ChangeTripStatusCommand(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Update trip status command starts");
        // the default path of transition in case of success
        String forward = Path.COMMAND_LIST_TRIPS;

        // get this session
        HttpSession session = request.getSession();
        // change trip status in the database flag

        String changeStatusTripId = request.getParameter("changeStatusTripId");

        // validation checks parameters to change trip status to BD. If not - throw exception
        if (changeStatusTripId != null && !changeStatusTripId.equals("") &&
                ValidUtils.isNumber(changeStatusTripId)) {

            // change status trip id (id = 4)
            // successfulExecutionUpdate - successful execution must be 1
            int successfulExecution = dbManager.updateTripStatus(Integer.valueOf(changeStatusTripId), 4);
            LOG.trace("Update trip status in DB: successful execution must be 1 --> " + successfulExecution);

            // put "okMessage" to request
            session.setAttribute("okMessage", "okMessageTripCanceled");
            LOG.trace("Set the request attribute: okMessage --> " + "okMessageTripCanceled");

        } else {
            LOG.error("Cannot change status!");
            throw new AppException("Cannot change status!");
        }

        LOG.debug("Update trip status command finished");
        return forward;
    }
}