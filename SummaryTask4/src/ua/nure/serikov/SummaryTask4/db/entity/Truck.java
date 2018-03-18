package ua.nure.serikov.SummaryTask4.db.entity;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class Truck extends Entity {

    private static final long serialVersionUID = 179976440494112830L;

    private String truckName = "no name";
    private double carrying;
    private double capacity;
    private double length;
    private boolean lorryWithSides = false;
    private boolean refrigerator = false;
    private boolean serviceable = true;
    private String photoLink = "truck.jpg";
    private int truckCountTrips;


    @Override
    public String toString() {
        return "Truck{" +
                "truck Name='" + truckName + '\'' +
                ", carrying=" + carrying +
                ", capacity=" + capacity +
                ", length=" + length +
                ", lorry With Sides=" + lorryWithSides +
                ", refrigerator=" + refrigerator +
                ", serviceable=" + serviceable +
                ", photo link='" + photoLink + '\'' +
                ", truck count trips='" + truckCountTrips + '\'' +
                '}';
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public double getCarrying() {
        return carrying;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isLorryWithSides() {
        return lorryWithSides;
    }

    public void setLorryWithSides(boolean lorryWithSides) {
        this.lorryWithSides = lorryWithSides;
    }

    public boolean isRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(boolean refrigerator) {
        this.refrigerator = refrigerator;
    }

    public boolean isServiceable() {
        return serviceable;
    }

    public void setServiceable(boolean serviceable) {
        this.serviceable = serviceable;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public int getTruckCountTrips() {
        return truckCountTrips;
    }

    public void setTruckCountTrips(int truckCountTrips) {
        this.truckCountTrips = truckCountTrips;
    }
}
