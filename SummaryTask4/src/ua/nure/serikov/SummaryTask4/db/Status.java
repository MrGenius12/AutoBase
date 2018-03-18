package ua.nure.serikov.SummaryTask4.db;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public enum Status {
    OPEN, IN_PROGRESS, CLOSED, CANCELED;

    public static Status getStatus(int statusId) {
        return Status.values()[statusId - 1];
    }

    public String getName() {
        return name().replace("_", " ").toLowerCase();
    }
}