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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

@RunWith(MockitoJUnitRunner.class)
public class ApproveRequestCommandTest {

	@Mock
	private DBManager dbManager;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private HttpSession session;

	private ApproveRequestCommand approveRequestCommand;
	private User user;

	@Before
	public void setUp() throws Exception {
		approveRequestCommand = new ApproveRequestCommand(dbManager);
		when(request.getSession()).thenReturn(session);
		user = new User();
		user.setRoleId(1);
	}

	@Test(expected = AppException.class)
	public void testExecuteNoParameters() throws Exception {
		approveRequestCommand.execute(request, response);
	}

	@Test(expected = AppException.class)
	public void testExecuteParameterOnlyUser() throws Exception {
		when(session.getAttribute("user")).thenReturn(user);
		approveRequestCommand.execute(request, response);
	}




	
}
