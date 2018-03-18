package ua.nure.serikov.SummaryTask4.web.command.common;

import org.junit.Test;

/**
 * AutoBase
 *
 * @author Serikov Eugene
 */

public class SortTripsTypesContainerTest {

    @Test
    public void testExecuteIsCorrectTypeOfSort() throws Exception {
        assert (SortTripsTypesContainer.isCorrectTypeOfSort("sortTripsTypeStatus"));
    }
}