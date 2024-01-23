package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StuffLendingSystemTest {

    private MemberRepository sut;

    @BeforeEach
    void setUp() {
        sut = new MemberRepository();
    }

    @Test
    void timeShouldBeInitializedToZero() {
        assertEquals(0, sut.getTime(), "Initial time should be zero");
    }

    @Test
    void advanceTimeShouldIncrementTimeByOne() {
        sut.advanceTime();
        assertEquals(1, sut.getTime(), "Time should be incremented by one after advanceTime");

        sut.advanceTime();
        assertEquals(2, sut.getTime(), "Time should be incremented by one again after another advanceTime");
    }

    @Test
    void getTimeShouldReturnCurrentTime() {
        int initialTime = sut.getTime();
        sut.advanceTime();
        int newTime = sut.getTime();

        assertNotEquals(initialTime, newTime, "New time should be different after advancing time");
        assertEquals(initialTime + 1, newTime, "New time should be initial time plus one after advancing time");
    }
}
