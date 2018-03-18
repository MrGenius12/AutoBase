package ua.nure.serikov.SummaryTask4;

/**
 * AutoBase
 * 
 * Path holder (jsp pages, controller commands).
 *
 * @author Serikov Eugene
 */
public final class Path {

    // commands
    public static final String COMMAND_LIST_TRIPS = "/controller?command=listTrips";
    public static final String COMMAND_LIST_REQUEST = "/controller?command=listRequests";
    public static final String COMMAND_LIST_TRUCKS = "/controller?command=listTrucks";
    public static final String COMMAND_LIST_USERS = "/controller?command=listUsers";
    public static final String COMMAND_PAGE_ERROR = "/controller?command=pageError";
    public static final String COMMAND_DRIVER_PERSONAL = "/controller?command=driverPersonal";

    // pages common
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_ERROR = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_SETTINGS = "/WEB-INF/jsp/settings/settings.jsp";

    // pages driver
    public static final String PAGE_LIST_TRIPS_DRIVER = "/WEB-INF/jsp/driver/list_trips_driver.jsp";
    public static final String PAGE_REQUEST_CREATE = "/WEB-INF/jsp/driver/request_create.jsp";
    public static final String PAGE_DRIVER_PERSONAL = "/WEB-INF/jsp/driver/driver_personal.jsp";

    // pages dispatcher
    public static final String PAGE_LIST_TRIPS = "/WEB-INF/jsp/dispatcher/list_trips.jsp";
    public static final String PAGE_LIST_TRIPS_APPROVE = "/WEB-INF/jsp/dispatcher/list_trips_approve.jsp";
    public static final String PAGE_TRIP_CREATE = "/WEB-INF/jsp/dispatcher/trip_create.jsp";
    public static final String PAGE_LIST_TRUCKS_DISP = "/WEB-INF/jsp/dispatcher/list_trucks_disp.jsp";
    public static final String PAGE_LIST_REQUESTS = "/WEB-INF/jsp/dispatcher/list_requests.jsp";
    public static final String PAGE_APPROVE_REQUEST = "/WEB-INF/jsp/dispatcher/approve_request.jsp";

    // pages admin
    public static final String PAGE_EDIT_TRUCK = "/WEB-INF/jsp/admin/edit_truck.jsp";
    public static final String PAGE_LIST_TRUCKS = "/WEB-INF/jsp/admin/list_trucks.jsp";
    public static final String PAGE_REGISTRATION_USER = "/WEB-INF/jsp/admin/registration_user.jsp";
    public static final String PAGE_LIST_USERS = "/WEB-INF/jsp/admin/list_users.jsp";
    public static final String PAGE_EDIT_USER = "/WEB-INF/jsp/admin/edit_user.jsp";
    public static final String PAGE_FIND_USER = "/WEB-INF/jsp/admin/find_user.jsp";
    public static final String PAGE_TRUCK_ADD = "/WEB-INF/jsp/admin/truck_add.jsp";
    //public static final String PAGE_TOTAL_CARRYING = "/WEB-INF/jsp/admin/total_carrying.jsp";

}