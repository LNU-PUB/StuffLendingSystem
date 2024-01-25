package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeServiceTest {

    private TimeService timeService;

    @BeforeEach
    void setUp() {
        timeService = new TimeService();
    }

    @Test
    void getDayShouldReturnCurrentDay() {
        int initialDay = timeService.getDay();
        // Assuming the initial day is 0 or as per your implementation
        assertEquals(0, initialDay, "Initial day should be 0");
    }

    @Test
    void advanceDayShouldIncrementDay() {
        int initialDay = timeService.getDay();
        timeService.advanceDay();
        int newDay = timeService.getDay();

        assertEquals(initialDay + 1, newDay, "Day should increment by one after advanceDay");
    }

    // Additional tests can be added as needed
}
