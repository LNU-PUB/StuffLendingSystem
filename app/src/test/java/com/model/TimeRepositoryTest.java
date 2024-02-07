package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.lib.TimeRepository;

import static org.junit.jupiter.api.Assertions.*;

class TimeRepositoryTest {

    private TimeRepository timeRepo;

    @BeforeEach
    void setUp() {
        timeRepo = new TimeRepository();
    }

    @Test
    void getDayShouldReturnCurrentDay() {
        int initialDay = timeRepo.getDay();
        // Assuming the initial day is 0 or as per your implementation
        assertEquals(0, initialDay, "Initial day should be 0");
    }

    @Test
    void advanceDayShouldIncrementDay() {
        int initialDay = timeRepo.getDay();
        timeRepo.advanceDay();
        int newDay = timeRepo.getDay();

        assertEquals(initialDay + 1, newDay, "Day should increment by one after advanceDay");
    }

    // Additional tests can be added as needed
}
