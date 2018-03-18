package ua.nure.serikov.SummaryTask4.db.bean;


import ua.nure.serikov.SummaryTask4.db.Role;
import ua.nure.serikov.SummaryTask4.db.Status;
import ua.nure.serikov.SummaryTask4.db.entity.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 * <p>
 * Provide records for virtual table:
 */
public class TripUserTruckBean extends Entity {

    private static final long serialVersionUID = -7037063837826161508L;

    private int beanTripNumber;
    private Date beanDateCreation;
    private Date beanDateDeparture;
    private String beanDestination;
    private Double beanDistance;
    private Status beanStatusName;
    private int beanStatusId;
    private int beanTruckId;
    private int beanDriverId;
    private int beanDispatcherIdCreate;
    private int beanDispatcherIdApprove;
    // driver from trip
    private String beanDriverFirstName;
    private String beanDriverLastName;
    private String beanDriverPhotoLink = "user.jpg";
    // who created trip
    private String beanDispatcherCreateFirstName;
    private String beanDispatcherCreateLastName;
    private String beanDispatcherCreatePhotoLink = "user.jpg";
    private int beanDispatcherCreateRoleId;
    private Role beanDispatcherCreateRoleName;
    // who approved trip
    private String beanDispatcherApproveFirstName;
    private String beanDispatcherApproveLastName;
    private String beanDispatcherApprovePhotoLink = "user.jpg";
    private int beanDispatcherApproveRoleId;
    private Role beanDispatcherApproveRoleName;
    private int beanRoleUserId;
    private String beanTruckPhotoLink = "truck.jpg";

    @Override
    public String toString() {
        return "TripUserTruckBean{" +
                "beanTripNumber=" + beanTripNumber +
                ", beanDateCreation=" + beanDateCreation +
                ", beanDateDeparture=" + beanDateDeparture +
                ", beanDestination='" + beanDestination + '\'' +
                ", beanDistance=" + beanDistance +
                ", beanStatusName=" + beanStatusName +
                ", beanStatusId=" + beanStatusId +
                ", beanTruckId=" + beanTruckId +
                ", beanDriverId=" + beanDriverId +
                ", beanDispatcherIdCreate=" + beanDispatcherIdCreate +
                ", beanDispatcherIdApprove=" + beanDispatcherIdApprove +
                ", beanDriverFirstName='" + beanDriverFirstName + '\'' +
                ", beanDriverLastName='" + beanDriverLastName + '\'' +
                ", beanDriverPhotoLink='" + beanDriverPhotoLink + '\'' +
                ", beanDispatcherCreateFirstName='" + beanDispatcherCreateFirstName + '\'' +
                ", beanDispatcherCreateLastName='" + beanDispatcherCreateLastName + '\'' +
                ", beanDispatcherCreatePhotoLink='" + beanDispatcherCreatePhotoLink + '\'' +
                ", beanDispatcherCreateRoleId=" + beanDispatcherCreateRoleId +
                ", beanDispatcherCreateRoleName=" + beanDispatcherCreateRoleName +
                ", beanDispatcherApproveFirstName='" + beanDispatcherApproveFirstName + '\'' +
                ", beanDispatcherApproveLastName='" + beanDispatcherApproveLastName + '\'' +
                ", beanDispatcherApprovePhotoLink='" + beanDispatcherApprovePhotoLink + '\'' +
                ", beanDispatcherApproveRoleId=" + beanDispatcherApproveRoleId +
                ", beanDispatcherApproveRoleName=" + beanDispatcherApproveRoleName +
                ", beanRoleUserId=" + beanRoleUserId +
                ", beanTruckPhotoLink='" + beanTruckPhotoLink + '\'' +
                '}';
    }

    public int getBeanTripNumber() {
        return beanTripNumber;
    }

    public void setBeanTripNumber(int beanTripNumber) {
        this.beanTripNumber = beanTripNumber;
    }

    public String getBeanDateCreation() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(beanDateCreation.getTime()));
    }

    public void setBeanDateCreation(Date beanDateCreation) {
        this.beanDateCreation = new Date(beanDateCreation.getTime());
    }

    public String getBeanDateDeparture() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(beanDateDeparture.getTime()));
    }

    public void setBeanDateDeparture(Date beanDateDeparture) {
        this.beanDateDeparture = new Date(beanDateDeparture.getTime());
    }

    public String getBeanDestination() {
        return beanDestination;
    }

    public void setBeanDestination(String beanDestination) {
        this.beanDestination = beanDestination;
    }

    public Double getBeanDistance() {
        return beanDistance;
    }

    public void setBeanDistance(Double beanDistance) {
        this.beanDistance = beanDistance;
    }

    public Status getBeanStatusName() {
        return beanStatusName;
    }

    public void setBeanStatusName(int statusId) {
        beanStatusName = Status.getStatus(statusId);
    }

    public int getBeanStatusId() {
        return beanStatusId;
    }

    public void setBeanStatusId(int beanStatusId) {
        this.beanStatusId = beanStatusId;
    }

    public int getBeanTruckId() {
        return beanTruckId;
    }

    public void setBeanTruckId(int beanTruckId) {
        this.beanTruckId = beanTruckId;
    }

    public int getBeanDriverId() {
        return beanDriverId;
    }

    public void setBeanDriverId(int beanDriverId) {
        this.beanDriverId = beanDriverId;
    }

    public int getBeanDispatcherIdCreate() {
        return beanDispatcherIdCreate;
    }

    public void setBeanDispatcherIdCreate(int beanDispatcherIdCreate) {
        this.beanDispatcherIdCreate = beanDispatcherIdCreate;
    }

    public int getBeanDispatcherIdApprove() {
        return beanDispatcherIdApprove;
    }

    public void setBeanDispatcherIdApprove(int beanDispatcherIdApprove) {
        this.beanDispatcherIdApprove = beanDispatcherIdApprove;
    }

    public String getBeanDriverFirstName() {
        return beanDriverFirstName;
    }

    public void setBeanDriverFirstName(String beanDriverFirstName) {
        this.beanDriverFirstName = beanDriverFirstName;
    }

    public String getBeanDriverLastName() {
        return beanDriverLastName;
    }

    public void setBeanDriverLastName(String beanDriverLastName) {
        this.beanDriverLastName = beanDriverLastName;
    }

    public String getBeanDriverPhotoLink() {
        return beanDriverPhotoLink;
    }

    public void setBeanDriverPhotoLink(String beanDriverPhotoLink) {
        this.beanDriverPhotoLink = beanDriverPhotoLink;
    }

    public String getBeanDispatcherCreateFirstName() {
        return beanDispatcherCreateFirstName;
    }

    public void setBeanDispatcherCreateFirstName(String beanDispatcherCreateFirstName) {
        this.beanDispatcherCreateFirstName = beanDispatcherCreateFirstName;
    }

    public String getBeanDispatcherCreateLastName() {
        return beanDispatcherCreateLastName;
    }

    public void setBeanDispatcherCreateLastName(String beanDispatcherCreateLastName) {
        this.beanDispatcherCreateLastName = beanDispatcherCreateLastName;
    }

    public String getBeanDispatcherCreatePhotoLink() {
        return beanDispatcherCreatePhotoLink;
    }

    public void setBeanDispatcherCreatePhotoLink(String beanDispatcherCreatePhotoLink) {
        this.beanDispatcherCreatePhotoLink = beanDispatcherCreatePhotoLink;
    }

    public int getBeanDispatcherCreateRoleId() {
        return beanDispatcherCreateRoleId;
    }

    public void setBeanDispatcherCreateRoleId(int beanDispatcherCreateId) {
        this.beanDispatcherCreateRoleId = beanDispatcherCreateId;
    }

    public Role getBeanDispatcherCreateRoleName() {
        return beanDispatcherCreateRoleName;
    }

    public void setBeanDispatcherCreateRoleName(int roleId) {
        this.beanDispatcherCreateRoleName = Role.getRole(roleId);
    }

    public String getBeanDispatcherApproveFirstName() {
        return beanDispatcherApproveFirstName;
    }

    public void setBeanDispatcherApproveFirstName(String beanDispatcherApproveFirstName) {
        this.beanDispatcherApproveFirstName = beanDispatcherApproveFirstName;
    }

    public String getBeanDispatcherApproveLastName() {
        return beanDispatcherApproveLastName;
    }

    public void setBeanDispatcherApproveLastName(String beanDispatcherApproveLastName) {
        this.beanDispatcherApproveLastName = beanDispatcherApproveLastName;
    }

    public String getBeanDispatcherApprovePhotoLink() {
        return beanDispatcherApprovePhotoLink;
    }

    public void setBeanDispatcherApprovePhotoLink(String beanDispatcherApprovePhotoLink) {
        this.beanDispatcherApprovePhotoLink = beanDispatcherApprovePhotoLink;
    }

    public int getBeanDispatcherApproveRoleId() {
        return beanDispatcherApproveRoleId;
    }

    public void setBeanDispatcherApproveRoleId(int beanDispatcherApproveId) {
        this.beanDispatcherApproveRoleId = beanDispatcherApproveId;
    }

    public Role getBeanDispatcherApproveRoleName() {
        return beanDispatcherApproveRoleName;
    }

    public void setBeanDispatcherApproveRoleName(int roleId) {
        this.beanDispatcherApproveRoleName = Role.getRole(roleId);
    }

    public int getBeanRoleUserId() {
        return beanRoleUserId;
    }

    public void setBeanRoleUserId(int beanRoleUserId) {
        this.beanRoleUserId = beanRoleUserId;
    }

    public String getBeanTruckPhotoLink() {
        return beanTruckPhotoLink;
    }

    public void setBeanTruckPhotoLink(String beanTruckPhotoLink) {
        this.beanTruckPhotoLink = beanTruckPhotoLink;
    }
}
