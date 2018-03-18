package ua.nure.serikov.SummaryTask4.web.command.common;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.entity.User;
import ua.nure.serikov.SummaryTask4.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

@RunWith(MockitoJUnitRunner.class)
public class ListTripsCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private ListTripsCommand listTripsCommand;
    private User user;

    @Before
    public void setUp() throws Exception {
        listTripsCommand = new ListTripsCommand(dbManager);
        when(request.getSession()).thenReturn(session);
        user = new User();
    }

    @Test(expected = AppException.class)
    public void testExecuteNoParameters() throws Exception {
        listTripsCommand.execute(request, response);
    }

    @Test(expected = Exception.class)
    public void testExecuteNoRoleByUser() throws Exception {
        when(session.getAttribute("user")).thenReturn(user);

        listTripsCommand.execute(request, response);
    }

    @Test
    public void testExecuteRoleDriverDBAllTrips() throws Exception {
        user.setRoleId(2);
        user.setId(1);
        when(session.getAttribute("user")).thenReturn(user);

        listTripsCommand.execute(request, response);
        // check the method call
        verify(dbManager).getAllTripsFromDriver(1);
    }

    @Test
    public void testExecuteRoleDriverCorrectForward() throws Exception {
        user.setRoleId(2);
        user.setId(1);
        when(session.getAttribute("user")).thenReturn(user);

        String result = listTripsCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_LIST_TRIPS_DRIVER, result);
    }

    @Test
    public void testExecuteRoleAdminDBAllTrips() throws Exception {
        user.setRoleId(1);
        when(session.getAttribute("user")).thenReturn(user);

        listTripsCommand.execute(request, response);

        // check the method call
        verify(dbManager).getAllTrip();
    }

    @Test
    public void testExecuteRoleAdminCorrectForward() throws Exception {
        user.setRoleId(1);
        when(session.getAttribute("user")).thenReturn(user);

        String result = listTripsCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_LIST_TRIPS, result);
    }
}