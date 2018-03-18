package ua.nure.serikov.SummaryTask4.web.command.driver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.DBManager;
import ua.nure.serikov.SummaryTask4.db.entity.Trip;
import ua.nure.serikov.SummaryTask4.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


/**
 *AutoBase
 *
 * @author Serikov Eugene
 */

@RunWith(MockitoJUnitRunner.class)
public class RequestCreateCommandTest {

    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private RequestCreateCommand requestCreateCommand;

    @Before
    public void setUp() throws Exception {
        requestCreateCommand = new RequestCreateCommand(dbManager);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testExecuteNoParameters() throws Exception {
        List<Trip> allTrips = new ArrayList<>();
        Trip trip = new Trip();
        trip.setId(1);
        allTrips.add(trip);

        when(session.getAttribute("allTrips")).thenReturn(allTrips);
        when(request.getParameter("idTrip")).thenReturn("1");

        String result = requestCreateCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_REQUEST_CREATE, result);
    }

    @Test
    public void testExecuteInsertToBD() throws Exception {
        User user = new User();
        user.setId(1);

        when(request.getParameter("insertToBD")).thenReturn("insertToBD");
        when(session.getAttribute("user")).thenReturn(user);
        when(session.getAttribute("tripId")).thenReturn("1");
        when(request.getParameter("carrying")).thenReturn("1");
        when(request.getParameter("capacity")).thenReturn("1");
        when(request.getParameter("length")).thenReturn("1");
        when(request.getParameter("lorryWithSides")).thenReturn("true");
        when(request.getParameter("refrigerator")).thenReturn("true");

        String result = requestCreateCommand.execute(request, response);

        // check Correct Forward
        assertEquals(Path.COMMAND_LIST_TRIPS, result);
    }
}