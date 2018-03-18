package ua.nure.serikov.SummaryTask4.web.command.dispatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
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
public class ChangeTripStatusCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private ChangeTripStatusCommand changeTripStatusCommand;

    @Before
    public void setUp() throws Exception {
        changeTripStatusCommand = new ChangeTripStatusCommand(dbManager);
        when(request.getSession()).thenReturn(session);
    }

    @Test(expected = AppException.class)
    public void testExecuteNoParameters() throws Exception {
        changeTripStatusCommand.execute(request, response);
    }

    @Test
    public void testExecuteCheckDBManagerDeleteTruck() throws Exception {
        when(request.getParameter("changeStatusTripId")).thenReturn("1");

        changeTripStatusCommand.execute(request, response);

        // check the method call
        verify(dbManager).updateTripStatus(1, 4);
    }

    @Test
    public void testExecuteCorrectForward() throws Exception {
        when(request.getParameter("changeStatusTripId")).thenReturn("1");
        String result = changeTripStatusCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.COMMAND_LIST_TRIPS, result);
    }
}