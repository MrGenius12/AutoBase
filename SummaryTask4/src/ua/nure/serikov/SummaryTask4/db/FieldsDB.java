package ua.nure.serikov.SummaryTask4.db;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * Holder for fields names of DB tables and beans.
 */
public final class FieldsDB {

    // entities
    public static final String ENTITY_ID = "id";

    public static final String USER_LOGIN = "user_login";
    public static final String USER_PASSWORD = "user_password";
    public static final String USER_FIRST_NAME = "user_first_name";
    public static final String USER_LAST_NAME = "user_last_name";
    public static final String USER_PHOTO_LINK = "user_photo_link";
    public static final String USER_MAIL = "user_mail";
    public static final String USER_ROLE_ID = "user_role_id";

    public static final String TRIP_NUMBER = "trip_number";
    public static final String TRIP_DATE_CREATION = "trip_date_creation";
    public static final String TRIP_DATE_DEPARTURE = "trip_date_departure";
    public static final String TRIP_DESTINATION = "trip_destination";
    public static final String TRIP_DISTANCE = "trip_distance";
    public static final String TRIP_STATUS_ID = "trip_status_id";
    public static final String TRIP_TRUCK_ID = "trip_truck_id";
    public static final String TRIP_DRIVER_ID = "trip_driver_id";
    public static final String TRIP_DISPATCHER_ID_CREATE = "trip_dispatcher_id_create";
    public static final String TRIP_DISPATCHER_ID_APPROVE = "trip_dispatcher_id_approve";

    public static final String REQUEST_TRIP_ID = "request_trip_id";
    public static final String REQUEST_CARRYING = "request_carrying";
    public static final String REQUEST_CAPACITY = "request_capacity";
    public static final String REQUEST_LENGTH = "request_length";
    public static final String REQUEST_LORRY_WITH_SIDES = "request_lorry_with_sides";
    public static final String REQUEST_REFRIGERATOR = "request_refrigerator";
    public static final String REQUEST_DRIVER_ID = "request_driver_id";

    public static final String TRUCK_NAME = "truck_name";
    public static final String TRUCK_CARRYING = "truck_carrying";
    public static final String TRUCK_CAPACITY = "truck_capacity";
    public static final String TRUCK_LENGTH = "truck_length";
    public static final String TRUCK_LORRY_WITH_SIDES = "truck_lorry_with_sides";
    public static final String TRUCK_REFRIGERATOR = "truck_refrigerator";
    public static final String TRUCK_SERVICEABLE = "truck_serviceable";
    public static final String TRUCK_PHOTO_LINK = "truck_photo_link";
    public static final String TRUCK_TRUCK_COUNT_TRIPS = "truck_count_trips";

    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_FIRST_NAME = "dispatcher_create_first_name";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_LAST_NAME = "dispatcher_create_last_name";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_PHOTO_LINK = "dispatcher_create_photo";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_ROLE_ID = "dispatcher_create_id";

    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_FIRST_NAME = "dispatcher_approve_first_name";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_LAST_NAME = "dispatcher_approve_last_name";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_PHOTO_LINK = "dispatcher_approve_photo";
    public static final String TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_ROLE_ID = "dispatcher_approve_id";



}