package ua.nure.serikov.SummaryTask4.web.command.driver;

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
import static org.mockito.Mockito.when;


/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

@RunWith(MockitoJUnitRunner.class)
public class TripCompletedCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private TripCompletedCommand tripCompletedCommand;

    @Before
    public void setUp() throws Exception {
        tripCompletedCommand = new TripCompletedCommand(dbManager);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testExecuteNoParameter() throws Exception {
        String result = tripCompletedCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_ERROR, result);
    }

    @Test(expected = AppException.class)
    public void testExecuteDriverPersonalIncorrectParameters() throws Exception {
        when(request.getParameter("insertToBD")).thenReturn("insertToBD");

        tripCompletedCommand.execute(request, response);
    }


    @Test
    public void testExecuteDriverPersonal() throws Exception {
        when(request.getParameter("insertToBD")).thenReturn("insertToBD");
        when(request.getParameter("tripId")).thenReturn("1");
        when(request.getParameter("truckId")).thenReturn("1");
        when(request.getParameter("isTruckServiceable")).thenReturn("true");

        String result = tripCompletedCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.COMMAND_DRIVER_PERSONAL, result);
    }
}