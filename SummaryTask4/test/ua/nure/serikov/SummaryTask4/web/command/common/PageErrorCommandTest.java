package ua.nure.serikov.SummaryTask4.web.command.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.serikov.SummaryTask4.Path;

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
public class PageErrorCommandTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    
    @Test
    public void testExecuteCorrectForward() throws Exception {
        when(request.getSession()).thenReturn(session);
        String result = new PageErrorCommand().execute(request, response);

        // check Correct Forward
        assertEquals(Path.PAGE_ERROR, result);
    }
}