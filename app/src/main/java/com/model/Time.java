package com.model;

/**
 * The time.
 */
public class Time {
  private final int currentDay;

  public Time() {
    this.currentDay = 0;
  }

  private Time(int currentDay) {
    this.currentDay = currentDay;
  }

  public Time advanceDay() {
    return new Time(this.currentDay + 1);
  }

  public int getCurrentDay() {
    return this.currentDay;
  }
}
