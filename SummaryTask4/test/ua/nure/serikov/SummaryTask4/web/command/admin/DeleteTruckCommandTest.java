package ua.nure.serikov.SummaryTask4.web.command.admin;

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
 *AutoBase
 *
 * @author Serikov Eugene
 */
@RunWith(MockitoJUnitRunner.class)
public class DeleteTruckCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private DeleteTruckCommand deleteTruckCommand;

    @Before
    public void setUp() throws Exception {
        deleteTruckCommand = new DeleteTruckCommand(dbManager);
        when(request.getSession()).thenReturn(session);
    }

    @Test(expected = AppException.class)
    public void testExecuteNoParameters() throws Exception {
        deleteTruckCommand.execute(request, response);
    }

    @Test
    public void testExecuteCheckDBManagerDeleteTruck() throws Exception {
        when(request.getParameter("deleteTruckId")).thenReturn("5");
        deleteTruckCommand.execute(request, response);

        // check the method call
        verify(dbManager).deleteTruck(5);
    }

    @Test
    public void testExecuteCorrectForward() throws Exception {
        when(request.getParameter("deleteTruckId")).thenReturn("5");
        String result = deleteTruckCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.COMMAND_LIST_TRUCKS, result);
    }
}