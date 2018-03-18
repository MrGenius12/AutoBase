package ua.nure.serikov.SummaryTask4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import ua.nure.serikov.SummaryTask4.db.RoleTest;
import ua.nure.serikov.SummaryTask4.db.StatusTest;
import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBeanTest;
import ua.nure.serikov.SummaryTask4.db.bean.RequestUserBeanTest;
import ua.nure.serikov.SummaryTask4.web.command.admin.*;
import ua.nure.serikov.SummaryTask4.web.command.common.*;
import ua.nure.serikov.SummaryTask4.web.command.dispatcher.ChangeTripStatusCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.dispatcher.DeleteRequestCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.dispatcher.TripCreateCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.dispatcher.ListRequestsCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.driver.DriverPersonalCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.driver.TripCompletedCommandTest;
import ua.nure.serikov.SummaryTask4.web.command.driver.RequestCreateCommandTest;


@RunWith(Suite.class)
@SuiteClasses({DeleteTruckCommandTest.class, DeleteUserCommandTest.class, EditTruckCommandTest.class,
        EditUserCommandTest.class, FindUserCommandTest.class, ListTrucksCommandTest.class, ListUsersCommandTest.class,
        RegistrationUserCommandTest.class, TruckAddCommandTest.class, ChangeLocaleCommandTest.class,
        ListTripsCommandTest.class, LoginCommandTest.class, LogoutUserCommandTest.class, NoCommandTest.class,
        PageErrorCommandTest.class, SortTripsCommandTest.class, SortTripsTypesContainerTest.class,
        ViewSettingsCommandTest.class, ChangeTripStatusCommandTest.class, DeleteRequestCommandTest.class,
        TripCreateCommandTest.class, ListRequestsCommandTest.class, DriverPersonalCommandTest.class,
        TripCompletedCommandTest.class, RequestCreateCommandTest.class, RoleTest.class, StatusTest.class,
        TripUserTruckBeanTest.class, RequestUserBeanTest.class})
public class AllTests {

}