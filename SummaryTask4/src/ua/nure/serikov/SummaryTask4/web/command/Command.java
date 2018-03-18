package ua.nure.serikov.SummaryTask4.web.command;

import ua.nure.serikov.SummaryTask4.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * Main interface for the Command pattern implementation.
 */
public abstract class Command {

    /**
     * Execution method for command.
     *
     * @return Address to go once the command is executed.
     */
    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException, AppException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}