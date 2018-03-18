package ua.nure.serikov.SummaryTask4.web.command.common;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

 /**
 * AutoBase
 *
 * @author Serikov Eugene
 */

    @RunWith(MockitoJUnitRunner.class)
    public class SortTripsCommandTest {

        @Mock
        private HttpServletRequest request;
        @Mock
        private HttpServletResponse response;
        @Mock
        private HttpSession session;

        private SortTripsCommand sortTripsCommand;
        private List allTrips;
        private User user;

        @Before
        public void setUp() throws Exception {
            sortTripsCommand = new SortTripsCommand();
            allTrips = new ArrayList<>();
            user = new User();
            when(request.getSession()).thenReturn(session);
            when(session.getAttribute("allTrips")).thenReturn(allTrips);
            when(session.getAttribute("user")).thenReturn(user);
        }


        @Test(expected = Exception.class)
        public void testExecuteNoParameters() throws Exception {
            sortTripsCommand.execute(request, response);
        }

        @Test
        public void testExecuteSortTripsDriver() throws Exception {
            user.setRoleId(2);
            when(request.getParameter("sortTripsType")).thenReturn("sortTripsTypeStatus");

            String result = sortTripsCommand.execute(request, response);

            // check Correct Forward
            assertEquals(Path.PAGE_LIST_TRIPS_DRIVER, result);
        }

        @Test
        public void testExecuteSortTripsTypeStatus() throws Exception {
            user.setRoleId(1);
            when(request.getParameter("sortTripsType")).thenReturn("sortTripsTypeStatus");

            String result = sortTripsCommand.execute(request, response);

            // check Correct Forward
            assertEquals(Path.PAGE_LIST_TRIPS, result);
        }
    }