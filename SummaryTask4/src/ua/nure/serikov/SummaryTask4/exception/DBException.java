package ua.nure.serikov.SummaryTask4.exception;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * An exception that provides information on a database access error.
 */
public class DBException extends AppException {

    private static final long serialVersionUID = 9082153673084391328L;

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

}
