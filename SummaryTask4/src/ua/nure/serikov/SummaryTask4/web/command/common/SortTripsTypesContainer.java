package ua.nure.serikov.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Sort Trips Container
 */
public class SortTripsTypesContainer {

    private static final Logger LOG = Logger.getLogger(SortTripsTypesContainer.class);
    private static List<String> typeSort = new ArrayList<>();

    static {
        // type sorts
        typeSort.add("sortTripsTypeDateCreation");
        typeSort.add("sortTripsTypeDateDeparture");
        typeSort.add("sortTripsTypeNumberTrip");
        typeSort.add("sortTripsTypeStatus");
        typeSort.add("sortTripsTypeDistance");
        typeSort.add("sortTripsTypeDestination");
        typeSort.add("sortTripsTypeFirstName");
        typeSort.add("sortTripsTypeLastName");

        LOG.debug("Sort Trips container was successfully initialized");
        LOG.trace("Number of sorts --> " + typeSort.size());
    }

    /**
     * Check correct type of sort
     *
     * @param typeSortTrips type of sort
     * @return contain or not this type
     */
    public static boolean isCorrectTypeOfSort(String typeSortTrips) {

        if (typeSortTrips == null || !typeSort.contains(typeSortTrips)) {
            LOG.debug("Sort trips container not found type sort of --> " + typeSortTrips);
            return false;
        }

        LOG.trace("type sort --> " + typeSortTrips);
        return true;
    }
}