package ua.nure.serikov.SummaryTask4.db;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *AutoBase
 *
 * @author Serikov Eugene
 */
public class StatusTest {

    @Test
    public void testGetStatus() throws Exception {
        assertEquals(Status.getStatus(1), Status.OPEN);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(Status.getStatus(1).getName(), "open");
    }
}