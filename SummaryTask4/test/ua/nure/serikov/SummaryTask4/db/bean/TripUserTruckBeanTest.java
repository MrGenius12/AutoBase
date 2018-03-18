package ua.nure.serikov.SummaryTask4.db.bean;

import org.junit.Test;
import ua.nure.serikov.SummaryTask4.db.Status;
import ua.nure.serikov.SummaryTask4.db.bean.TripUserTruckBean;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */
public class TripUserTruckBeanTest {

    TripUserTruckBean tripUserTruckBean = new TripUserTruckBean();
    Date date = new Date();

    @Test
    public void testTripUserTruckBeanGetSetId() throws Exception {
        tripUserTruckBean.setId(1);
        assertTrue(tripUserTruckBean.getId() == 1);
    }

    @Test
    public void testTripUserTruckBeanGetSetTripNumber() throws Exception {
        tripUserTruckBean.setBeanTripNumber(1);
        assertTrue(tripUserTruckBean.getBeanTripNumber() == 1);
    }

    @Test
    public void testTripUserTruckBeanGetSetDistance() throws Exception {
        tripUserTruckBean.setBeanDistance(1.1);
        assertTrue(tripUserTruckBean.getBeanDistance() == 1.1);
    }

    @Test
    public void testTripUserTruckBeanGetSetStatusName() throws Exception {
        tripUserTruckBean.setBeanStatusName(1);
        assertEquals(tripUserTruckBean.getBeanStatusName(), Status.OPEN);
    }

    @Test
    public void testTripUserTruckBeanGetSetDestination() throws Exception {
        tripUserTruckBean.setBeanDestination("Destination");
        assertEquals(tripUserTruckBean.getBeanDestination(), "Destination");
    }

    @Test
    public void testTripUserTruckBeanGetSetStatusId() throws Exception {
        tripUserTruckBean.setBeanStatusId(2);
        assertTrue(tripUserTruckBean.getBeanStatusId() == 2);
    }

    @Test
    public void testTripUserTruckBeanGetSetTruckId() throws Exception {
        tripUserTruckBean.setBeanTruckId(3);
        assertTrue(tripUserTruckBean.getBeanTruckId() == 3);
    }

    @Test
    public void testTripUserTruckBeanGetSetDriverId() throws Exception {
        tripUserTruckBean.setBeanDriverId(4);
        assertTrue(tripUserTruckBean.getBeanDriverId() == 4);
    }

    @Test
    public void testTripUserTruckBeanGetSetDispatcherIdCreate() throws Exception {
        tripUserTruckBean.setBeanDispatcherIdCreate(5);
        assertTrue(tripUserTruckBean.getBeanDispatcherIdCreate() == 5);
    }

    @Test
    public void testTripUserTruckBeanGetSetDispatcherIdApprove() throws Exception {
        tripUserTruckBean.setBeanDispatcherIdApprove(6);
        assertTrue(tripUserTruckBean.getBeanDispatcherIdApprove() == 6);
    }

    @Test
    public void testTripUserTruckBeanGetSetDriverFirstName() throws Exception {
        tripUserTruckBean.setBeanDriverFirstName("DriverFirstName");
        assertEquals(tripUserTruckBean.getBeanDriverFirstName(), "DriverFirstName");
    }

    @Test
    public void testTripUserTruckBeanGetSetDriverLastName() throws Exception {
        tripUserTruckBean.setBeanDriverLastName("LastName");
        assertEquals(tripUserTruckBean.getBeanDriverLastName(), "LastName");
    }

    @Test
    public void testTripUserTruckBeanGetSetDriverPhotoLink() throws Exception {
        tripUserTruckBean.setBeanDriverPhotoLink("PhotoLink");
        assertEquals(tripUserTruckBean.getBeanDriverPhotoLink(), "PhotoLink");
    }

    @Test
    public void testTripUserTruckBeanGetSetRoleUserId() throws Exception {
        tripUserTruckBean.setBeanRoleUserId(7);
        assertTrue(tripUserTruckBean.getBeanRoleUserId() == 7);
    }

    @Test
    public void testTripUserTruckBeanGetSetDriverTruckPhotoLink() throws Exception {
        tripUserTruckBean.setBeanTruckPhotoLink("TruckPhotoLink");
        assertEquals(tripUserTruckBean.getBeanTruckPhotoLink(), "TruckPhotoLink");
    }

    @Test
    public void testTripUserTruckBeanToString() throws Exception {
        assertNotNull(tripUserTruckBean.toString());
    }
}