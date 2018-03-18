package ua.nure.serikov.SummaryTask4.exception;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * An exception that provides information on an application error.
 */
public class AppException extends Exception {

    private static final long serialVersionUID = -154808010449666166L;

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

}
