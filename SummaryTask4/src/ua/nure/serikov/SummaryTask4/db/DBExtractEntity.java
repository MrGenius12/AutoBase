package ua.nure.serikov.SummaryTask4.db;

import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBean;
import ua.nure.serikov.SummaryTask4.db.bean.RequestUserBean;
import ua.nure.serikov.SummaryTask4.db.entity.Trip;
import ua.nure.serikov.SummaryTask4.db.entity.Truck;
import ua.nure.serikov.SummaryTask4.db.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class DBExtractEntity {

    private static String defaultPhotoUser = "user.jpg";
    private static String defaultPhotoTruck = "truck.jpg";

    /**
     * Extracts a user entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return User entity
     */
    public static User extractUser(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getInt(FieldsDB.ENTITY_ID));
        user.setLogin(rs.getString(FieldsDB.USER_LOGIN));
        user.setPassword(rs.getString(FieldsDB.USER_PASSWORD));
        user.setFirstName(rs.getString(FieldsDB.USER_FIRST_NAME));
        user.setLastName(rs.getString(FieldsDB.USER_LAST_NAME));
        String photoLinkUser = rs.getString(FieldsDB.USER_PHOTO_LINK);
        if (photoLinkUser == null) {
            photoLinkUser = defaultPhotoUser;
        }
        user.setPhotoLink(photoLinkUser);
        user.setMail(rs.getString(FieldsDB.USER_MAIL));
        user.setRoleId(rs.getInt(FieldsDB.USER_ROLE_ID));
        user.setRoleName(rs.getInt(FieldsDB.USER_ROLE_ID));

        return user;
    }


    /**
     * Extracts a TripUserTruckBean entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return TripUserTruckBean
     */
    public static TripUserTruckBean extractTripUserTruckBean(ResultSet rs) throws SQLException {
        TripUserTruckBean tripUserTruckBean = new TripUserTruckBean();

        tripUserTruckBean.setId(rs.getInt(FieldsDB.ENTITY_ID));
        tripUserTruckBean.setBeanTripNumber(rs.getInt(FieldsDB.TRIP_NUMBER));
        tripUserTruckBean.setBeanDateCreation(rs.getDate(FieldsDB.TRIP_DATE_CREATION));
        tripUserTruckBean.setBeanDateDeparture(rs.getDate(FieldsDB.TRIP_DATE_DEPARTURE));
        tripUserTruckBean.setBeanDestination(rs.getString(FieldsDB.TRIP_DESTINATION));
        tripUserTruckBean.setBeanDistance(rs.getDouble(FieldsDB.TRIP_DISTANCE));
        tripUserTruckBean.setBeanStatusName(rs.getInt(FieldsDB.TRIP_STATUS_ID));
        tripUserTruckBean.setBeanStatusId(rs.getInt(FieldsDB.TRIP_STATUS_ID));
        tripUserTruckBean.setBeanTruckId(rs.getInt(FieldsDB.TRIP_TRUCK_ID));
        tripUserTruckBean.setBeanDriverId(rs.getInt(FieldsDB.TRIP_DRIVER_ID));
        tripUserTruckBean.setBeanDispatcherIdCreate(rs.getInt(FieldsDB.TRIP_DISPATCHER_ID_CREATE));
        tripUserTruckBean.setBeanDispatcherIdApprove(rs.getInt(FieldsDB.TRIP_DISPATCHER_ID_APPROVE));

        tripUserTruckBean.setBeanDriverFirstName(rs.getString(FieldsDB.USER_FIRST_NAME));
        tripUserTruckBean.setBeanDriverLastName(rs.getString(FieldsDB.USER_LAST_NAME));
        String driverPhotoLink = rs.getString(FieldsDB.USER_PHOTO_LINK);
        if (driverPhotoLink == null) {
            driverPhotoLink = defaultPhotoUser;
        }
        tripUserTruckBean.setBeanDriverPhotoLink(driverPhotoLink);
        tripUserTruckBean.setBeanRoleUserId(rs.getInt(FieldsDB.USER_ROLE_ID));

        String truckPhotoLink = rs.getString(FieldsDB.TRUCK_PHOTO_LINK);
        if (truckPhotoLink == null) {
            truckPhotoLink = defaultPhotoTruck;
        }
        tripUserTruckBean.setBeanTruckPhotoLink(truckPhotoLink);

        // who created trip
        tripUserTruckBean.setBeanDispatcherCreateFirstName(rs.getString(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_FIRST_NAME));
        tripUserTruckBean.setBeanDispatcherCreateLastName(rs.getString(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_LAST_NAME));
        String dispatcherCreatePhotoLink = rs.getString(FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_PHOTO_LINK);
        if (dispatcherCreatePhotoLink == null) {
            dispatcherCreatePhotoLink = defaultPhotoUser;
        }
        tripUserTruckBean.setBeanDispatcherCreatePhotoLink(dispatcherCreatePhotoLink);
        tripUserTruckBean.setBeanDispatcherCreateRoleId(rs.getInt(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_ROLE_ID));
        tripUserTruckBean.setBeanDispatcherCreateRoleName(rs.getInt(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_CREATE_ROLE_ID));

        // who approved trip
        tripUserTruckBean.setBeanDispatcherApproveFirstName(rs.getString(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_FIRST_NAME));
        tripUserTruckBean.setBeanDispatcherApproveLastName(rs.getString(
                FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_LAST_NAME));
        String dispatcherApprovePhotoLink = rs.getString(FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_PHOTO_LINK);
        if (dispatcherApprovePhotoLink == null) {
            dispatcherApprovePhotoLink = defaultPhotoUser;
        }
        tripUserTruckBean.setBeanDispatcherApprovePhotoLink(dispatcherApprovePhotoLink);

        int dispatcherApproveRoleId = rs.getInt(FieldsDB.TRIP_USER_TRUCK_BEAN_DISPATCHER_APPROVE_ROLE_ID);
        tripUserTruckBean.setBeanDispatcherApproveRoleId(dispatcherApproveRoleId);
        if (dispatcherApproveRoleId != 0) {
            tripUserTruckBean.setBeanDispatcherApproveRoleName(dispatcherApproveRoleId);
        }

        return tripUserTruckBean;
    }


    /**
     * Extracts a RequestUserBean entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return RequestUserBean
     */
    public static RequestUserBean extractRequestUserBean(ResultSet rs) throws SQLException {
        RequestUserBean requestUserBean = new RequestUserBean();

        requestUserBean.setId(rs.getInt(FieldsDB.ENTITY_ID));
        requestUserBean.setBeanTripId(rs.getInt(FieldsDB.REQUEST_TRIP_ID));
        requestUserBean.setBeanCarrying(rs.getDouble(FieldsDB.REQUEST_CARRYING));
        requestUserBean.setBeanCapacity(rs.getDouble(FieldsDB.REQUEST_CAPACITY));
        requestUserBean.setBeanLength(rs.getDouble(FieldsDB.REQUEST_LENGTH));
        requestUserBean.setBeanLorryWithSides(rs.getBoolean(FieldsDB.REQUEST_LORRY_WITH_SIDES));
        requestUserBean.setBeanRefrigerator(rs.getBoolean(FieldsDB.REQUEST_REFRIGERATOR));
        requestUserBean.setBeanDriverId(rs.getInt(FieldsDB.REQUEST_DRIVER_ID));

        requestUserBean.setBeanDriverFirstName(rs.getString(FieldsDB.USER_FIRST_NAME));
        requestUserBean.setBeanDriverLastName(rs.getString(FieldsDB.USER_LAST_NAME));
        String driverPhotoLink = rs.getString(FieldsDB.USER_PHOTO_LINK);
        if (driverPhotoLink == null) {
            driverPhotoLink = defaultPhotoUser;
        }
        requestUserBean.setBeanDriverPhotoLink(driverPhotoLink);
        requestUserBean.setBeanRoleId(rs.getInt(FieldsDB.USER_ROLE_ID));

        requestUserBean.setBeanTripNumber(rs.getInt(FieldsDB.TRIP_NUMBER));
        requestUserBean.setBeanDateDeparture(rs.getDate(FieldsDB.TRIP_DATE_DEPARTURE));
        requestUserBean.setBeanDestination(rs.getString(FieldsDB.TRIP_DESTINATION));

        return requestUserBean;
    }


    /**
     * Extracts a Truck entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return Truck entity
     */
    public static Truck extractTruck(ResultSet rs) throws SQLException {
        Truck truck = new Truck();

        truck.setId(rs.getInt(FieldsDB.ENTITY_ID));
        truck.setTruckName(rs.getString(FieldsDB.TRUCK_NAME));
        truck.setCarrying(rs.getDouble(FieldsDB.TRUCK_CARRYING));
        truck.setCapacity(rs.getDouble(FieldsDB.TRUCK_CAPACITY));
        truck.setLength(rs.getDouble(FieldsDB.TRUCK_LENGTH));
        truck.setLorryWithSides(rs.getBoolean(FieldsDB.TRUCK_LORRY_WITH_SIDES));
        truck.setRefrigerator(rs.getBoolean(FieldsDB.TRUCK_REFRIGERATOR));
        truck.setServiceable(rs.getBoolean(FieldsDB.TRUCK_SERVICEABLE));
        String truckPhotoLink = rs.getString(FieldsDB.TRUCK_PHOTO_LINK);
        if (truckPhotoLink == null) {
            truckPhotoLink = defaultPhotoTruck;
        }
        truck.setPhotoLink(truckPhotoLink);
        truck.setTruckCountTrips(rs.getInt(FieldsDB.TRUCK_TRUCK_COUNT_TRIPS));

        return truck;
    }

    /**
     * Extracts a TripUserTruckBean entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return TripUserTruckBean
     */
    public static TripUserTruckBean extractTripTruckBeanFromDriver(ResultSet rs) throws SQLException {
        TripUserTruckBean tripUserTruckBeanFromDriver = new TripUserTruckBean();

        tripUserTruckBeanFromDriver.setId(rs.getInt(FieldsDB.ENTITY_ID));
        tripUserTruckBeanFromDriver.setBeanTripNumber(rs.getInt(FieldsDB.TRIP_NUMBER));
        tripUserTruckBeanFromDriver.setBeanDateCreation(rs.getDate(FieldsDB.TRIP_DATE_CREATION));
        tripUserTruckBeanFromDriver.setBeanDateDeparture(rs.getDate(FieldsDB.TRIP_DATE_DEPARTURE));
        tripUserTruckBeanFromDriver.setBeanDestination(rs.getString(FieldsDB.TRIP_DESTINATION));
        tripUserTruckBeanFromDriver.setBeanDistance(rs.getDouble(FieldsDB.TRIP_DISTANCE));
        tripUserTruckBeanFromDriver.setBeanStatusName(rs.getInt(FieldsDB.TRIP_STATUS_ID));
        tripUserTruckBeanFromDriver.setBeanStatusId(rs.getInt(FieldsDB.TRIP_STATUS_ID));
        tripUserTruckBeanFromDriver.setBeanTruckId(rs.getInt(FieldsDB.TRIP_TRUCK_ID));
        tripUserTruckBeanFromDriver.setBeanDriverId(rs.getInt(FieldsDB.TRIP_DRIVER_ID));

        String truckPhotoLink = rs.getString(FieldsDB.TRUCK_PHOTO_LINK);
        if (truckPhotoLink == null) {
            truckPhotoLink = defaultPhotoTruck;
        }
        tripUserTruckBeanFromDriver.setBeanTruckPhotoLink(truckPhotoLink);

        return tripUserTruckBeanFromDriver;
    }

    /**
     * Extracts a Trip entity from the result set.
     *
     * @param rs Result set from which a user entity will be extracted.
     * @return Trip entity
     */
    public static Trip extractTrip(ResultSet rs) throws SQLException {
        Trip trip = new Trip();

        trip.setId(rs.getInt(FieldsDB.ENTITY_ID));
        trip.setTripNumber(rs.getInt(FieldsDB.TRIP_NUMBER));
        trip.setDateCreation(rs.getDate(FieldsDB.TRIP_DATE_CREATION));
        trip.setDateDeparture(rs.getDate(FieldsDB.TRIP_DATE_DEPARTURE));
        trip.setDestination(rs.getString(FieldsDB.TRIP_DESTINATION));
        trip.setDistance(rs.getDouble(FieldsDB.TRIP_DISTANCE));
        trip.setStatusName(rs.getInt(FieldsDB.TRIP_STATUS_ID));
        trip.setTruckId(rs.getInt(FieldsDB.TRIP_TRUCK_ID));
        trip.setDriverId(rs.getInt(FieldsDB.TRIP_DRIVER_ID));
        trip.setDispatcherIdCreate(rs.getInt(FieldsDB.TRIP_DISPATCHER_ID_CREATE));
        trip.setDispatcherIdApprove(rs.getInt(FieldsDB.TRIP_DISPATCHER_ID_APPROVE));

        return trip;
    }
}
