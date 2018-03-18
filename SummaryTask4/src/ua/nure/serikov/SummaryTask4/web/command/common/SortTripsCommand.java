package ua.nure.serikov.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;
import ua.nure.serikov.SummaryTask4.Path;
import ua.nure.serikov.SummaryTask4.db.Role;
import ua.nure.serikov.SummaryTask4.db.Status;
import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBean;
import ua.nure.serikov.SummaryTask4.db.entity.User;
import ua.nure.serikov.SummaryTask4.exception.AppException;
import ua.nure.serikov.SummaryTask4.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sort trips.
 */
public class SortTripsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(SortTripsCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Sort trips Commands starts");
        // the default path of transition in case of success
        String forward = Path.PAGE_LIST_TRIPS;

        // the approve list trips path of transition if has flag
        String approve = request.getParameter("approve");
        if (approve != null && approve.equals("approve")) {
            forward = Path.PAGE_LIST_TRIPS_APPROVE;
            LOG.debug("forward -> approve list trips");
        }

        // get this session
        HttpSession session = request.getSession();

        String sortTripsType = request.getParameter("sortTripsType");
        LOG.debug("Sort trips Type --> " + sortTripsType);

        if (SortTripsTypesContainer.isCorrectTypeOfSort(sortTripsType)) {

            LOG.trace("parameter of type sort correct");
            List<TripUserTruckBean> allTrips = (ArrayList<TripUserTruckBean>) session.getAttribute("allTrips");
            LOG.trace("Attribute allTrips --> " + allTrips);
            User user = (User) session.getAttribute("user");
            LOG.trace("Attribute user --> " + user);

            if (Role.getRole(user) == Role.DRIVER) {

                LOG.info("Role user DRIVER");
                forward = Path.PAGE_LIST_TRIPS_DRIVER;
                List<TripUserTruckBean> allOpenTripsFromDrivers = new ArrayList<>();

                for (TripUserTruckBean trip : allTrips) {
                    if (trip.getBeanStatusName().equals(Status.OPEN)) {
                        allOpenTripsFromDrivers.add(trip);
                    }
                }
                allTrips = allOpenTripsFromDrivers;
            }

            // sort trips by date creation
            if (sortTripsType.equals("sortTripsTypeDateCreation")) {

                LOG.trace("sort trips by date creation");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        if (o1.getBeanDateCreation() == null || o2.getBeanDateCreation() == null) {
                            return 0;
                        }
                        return o1.getBeanDateCreation().compareTo(o2.getBeanDateCreation());
                    }
                });
            }

            // sort trips by date Departure
            if (sortTripsType.equals("sortTripsTypeDateDeparture")) {

                LOG.trace("sort trips by date Departure");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        if (o1.getBeanDateDeparture() == null || o2.getBeanDateDeparture() == null) {
                            return 0;
                        }
                        return o1.getBeanDateDeparture().compareTo(o2.getBeanDateDeparture());
                    }
                });
            }

            // sort trips by Trip Number
            if (sortTripsType.equals("sortTripsTypeNumberTrip")) {

                LOG.trace("sort trips by Trip Number");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return o1.getBeanTripNumber() - o2.getBeanTripNumber();
                    }
                });
            }

            // sort trips by status
            if (sortTripsType.equals("sortTripsTypeStatus")) {

                LOG.trace("sort trips by status");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return o1.getBeanStatusId() - o2.getBeanStatusId();
                    }
                });

            }

            // sort trips by distance
            if (sortTripsType.equals("sortTripsTypeDistance")) {

                LOG.trace("sort trips by distance");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return (int) (o1.getBeanDistance() - o2.getBeanDistance());
                    }
                });

            }

            // sort trips by distance
            if (sortTripsType.equals("sortTripsTypeDestination")) {

                LOG.trace("sort trips by destination");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return nullSafeStringComparator(o1.getBeanDestination(), o2.getBeanDestination());
                    }
                });

            }

            // sort trips by first name
            if (sortTripsType.equals("sortTripsTypeFirstName")) {

                LOG.trace("sort trips by first name");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return nullSafeStringComparator(o1.getBeanDriverFirstName(), o2.getBeanDriverFirstName());
                    }
                });

            }

            // sort trips by last name
            if (sortTripsType.equals("sortTripsTypeLastName")) {

                LOG.trace("sort trips by last name");
                Collections.sort(allTrips, new Comparator<TripUserTruckBean>() {
                    public int compare(TripUserTruckBean o1, TripUserTruckBean o2) {
                        return nullSafeStringComparator(o1.getBeanDriverLastName(), o2.getBeanDriverLastName());
                    }
                });
            }

            // put all trips list to request
            session.setAttribute("allTrips", allTrips);
            LOG.trace("Set the request attribute: allTrips");

        } else {
            LOG.error("No parameter of type sort!");
            throw new AppException("No parameter of type sort!");
        }

        LOG.debug("Sort Trips Commands finished");
        return forward;
    }

    public static int nullSafeStringComparator(final String one, final String two) {
        if (one == null ^ two == null) {
            return (one == null) ? -1 : 1;
        }

        if (one == null && two == null) {
            return 0;
        }

        return one.compareToIgnoreCase(two);
    }
}