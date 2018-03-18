package ua.nure.serikov.SummaryTask4.db.entity;

import ua.nure.serikov.SummaryTask4.db.Status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class Trip extends Entity {

    private static final long serialVersionUID = 2729829938052138364L;

    private int tripNumber;
    private Date dateCreation;
    private Date dateDeparture;
    private String destination;
    private double distance;
    private Status statusName;
    private int truckId;
    private int driverId;
    private int dispatcherIdCreate;
    private int dispatcherIdApprove;

    @Override
    public String toString() {
        return "Trip{" +
                "trip Number=" + tripNumber +
                ", date Creation=" + dateCreation +
                ", date Departure=" + dateDeparture +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", status Name=" + statusName +
                ", truck Id=" + truckId +
                ", driver Id=" + driverId +
                ", dispatcher Id who Created=" + dispatcherIdCreate +
                ", driver Id who Approve=" + dispatcherIdApprove +
                '}';
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getDateCreation() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateCreation.getTime()));
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = new Date(dateCreation.getTime());
    }

    public String getDateDeparture() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateDeparture.getTime()));
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = new Date(dateDeparture.getTime());
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Status getStatusName() {
        return statusName;
    }

    public void setStatusName(int statusId) {
        this.statusName = Status.getStatus(statusId);
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getDispatcherIdCreate() {
        return dispatcherIdCreate;
    }

    public void setDispatcherIdCreate(int dispatcherIdCreate) {
        this.dispatcherIdCreate = dispatcherIdCreate;
    }

    public int getDispatcherIdApprove() {
        return dispatcherIdApprove;
    }

    public void setDispatcherIdApprove(int dispatcherIdApprove) {
        this.dispatcherIdApprove = dispatcherIdApprove;
    }


}
