package ua.nure.serikov.SummaryTask4.web.command.dispatcher;

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
import static org.mockito.Mockito.when;


/**
 *AutoBase
 *
 * @author Serikov Eugene
 */

@RunWith(MockitoJUnitRunner.class)
public class TripCreateCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private TripCreateCommand tripCreateCommand;
    private User user;

    @Before
    public void setUp() throws Exception {
        tripCreateCommand = new TripCreateCommand(dbManager);
        when(request.getSession()).thenReturn(session);
        user = new User();
        user.setRoleId(1);
    }

    @Test(expected = AppException.class)
    public void testExecuteNoUserParameter() throws Exception {
        tripCreateCommand.execute(request, response);
    }

    @Test
    public void testExecuteNoInsertToBD() throws Exception {
        when(session.getAttribute("user")).thenReturn(user);

        String result = tripCreateCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_TRIP_CREATE, result);
    }

    @Test
    public void testExecuteInsertToBD() throws Exception {
        when(session.getAttribute("user")).thenReturn(user);
        when(request.getParameter("insertToBD")).thenReturn("insertToBD");
        when(request.getParameter("tripNumber")).thenReturn("2");
        when(request.getParameter("dateDeparture")).thenReturn("2099-12-01");
        when(request.getParameter("destination")).thenReturn("destination");
        when(request.getParameter("distance")).thenReturn("2");

        String result = tripCreateCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.COMMAND_LIST_TRIPS, result);
    }
}