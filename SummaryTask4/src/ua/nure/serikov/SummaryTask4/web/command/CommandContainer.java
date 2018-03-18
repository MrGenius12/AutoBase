package ua.nure.serikov.SummaryTask4.web.command;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.exception.DBException;
import ua.nure.serikov.SummaryTask4.web.command.admin.*;
import ua.nure.serikov.SummaryTask4.web.command.common.*;
import ua.nure.serikov.SummaryTask4.web.command.dispatcher.*;
import ua.nure.serikov.SummaryTask4.web.command.driver.DriverPersonalCommand;
import ua.nure.serikov.SummaryTask4.web.command.driver.TripCompletedCommand;
import ua.nure.serikov.SummaryTask4.web.command.driver.RequestCreateCommand;

import java.util.Map;
import java.util.TreeMap;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 *
 * Holder for all commands.
 */
public class CommandContainer {

    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<String, Command>();

    static {
        DBManager dbManager;
        try {
            dbManager = DBManager.getInstance();
        } catch (DBException e) {
            LOG.error("dbManager don`t init");
            throw new IllegalStateException(e);
        }

        // common commands
        commands.put("login", new LoginCommand(dbManager));
        commands.put("logout", new LogoutUserCommand());
        commands.put("viewSettings", new ViewSettingsCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("changeLocale", new ChangeLocaleCommand());
        commands.put("listTrips", new ListTripsCommand(dbManager));
        commands.put("sortTrips", new SortTripsCommand());
        commands.put("pageError", new PageErrorCommand());

        // admin commands
        commands.put("listTrucks", new ListTrucksCommand(dbManager));
        commands.put("truckAdd", new TruckAddCommand(dbManager));
        commands.put("registrationUser", new RegistrationUserCommand(dbManager));
        commands.put("listUsers", new ListUsersCommand(dbManager));
        commands.put("deleteTruck", new DeleteTruckCommand(dbManager));
        commands.put("deleteUser", new DeleteUserCommand(dbManager));
        commands.put("editTruck", new EditTruckCommand(dbManager));
        commands.put("editUser", new EditUserCommand(dbManager));
        commands.put("findUser", new FindUserCommand(dbManager));
        commands.put("deleteTrip", new DeleteTripCommand(dbManager));

        // driver commands
        commands.put("requestCreate", new RequestCreateCommand(dbManager));
        commands.put("driverPersonal", new DriverPersonalCommand(dbManager));
        commands.put("tripCompleted", new TripCompletedCommand(dbManager));

        // dispatcher commands
        commands.put("tripCreate", new TripCreateCommand(dbManager));
        commands.put("listRequests", new ListRequestsCommand(dbManager));
        commands.put("approveRequest", new ApproveRequestCommand(dbManager));
        commands.put("deleteRequest", new DeleteRequestCommand(dbManager));
        commands.put("changeTripStatus", new ChangeTripStatusCommand(dbManager));

        LOG.debug("Command container was successfully initialized");
        LOG.trace("Number of commands --> " + commands.size());
    }

    /**
     * Returns command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        LOG.trace("Command name --> " + commandName);
        return commands.get(commandName);
    }
}