package ua.nure.serikov.SummaryTask4.exception;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * Holder for messages of exceptions.
 */
public final class Messages {

    private Messages() {

    }

    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

    public static final String ERR_CANNOT_DELETE_TRUCK = "Cannot delete this truck, \n" +
            "because he was appointed to the trip";

    public static final String ERR_CANNOT_DELETE_REQUEST = "Cannot delete this request!";

    public static final String ERR_CANNOT_DELETE_REQUEST_BY_DRIVER = "Cannot delete your request!";

    public static final String ERR_CANNOT_DELETE_USER = "Cannot delete this user! \n" +
            "because he was appointed to the trip!";

    public static final String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";

    public static final String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain a users";

    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";

    public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";

    public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";

    public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";

    public static final String ERR_CANNOT_FIND_USER_BY_LOGIN = "Cannot find user by login";

    public static final String ERR_CANNOT_FIND_USER_BY_ID = "cannot obtain user by id";

    public static final String ERR_CANNOT_INSERT_USER = "Cannot insert user";

    public static final String ERR_CANNOT_UPDATE_USER = "Cannot update user";

    public static final String ERR_CANNOT_FIND_ALL_EMAILS = "Cannot obtain emails";

    public static final String ERR_CANNOT_OBTAIN_ALL_TRIP = "cannot obtain all trip";

    public static final String ERR_CANNOT_OBTAIN_ALL_TRIP_FROM_DRIVER = "cannot obtain all trip from driver";

    public static final String ERR_CANNOT_INSERT_TRIP = "Cannot insert trip";

    public static final String ERR_CANNOT_UPDATE_TRIP_STATUS = "Cannot update trip Status";

    public static final String ERR_CANNOT_UPDATE_TRIP = "Cannot update trip";

    public static final String ERR_CANNOT_UPDATE_TRIP_APPROVE_REQUEST = "Cannot update trip approve request";

    public static final String ERR_CANNOT_OBTAIN_ALL_REQUESTS = "cannot obtain all requests";

    public static final String ERR_CANNOT_INSERT_REQUESTS = "Cannot insert requests";

    public static final String ERR_CANNOT_OBTAIN_ALL_TRUCKS = "cannot obtain all trucks";

    public static final String ERR_CANNOT_OBTAIN_TRUCK_BY_ID = "cannot obtain truck by id";

    public static final String ERR_CANNOT_INSERT_TRUCK = "Cannot insert truck";

    public static final String ERR_CANNOT_UPDATE_TRUCK = "Cannot update truck";

}