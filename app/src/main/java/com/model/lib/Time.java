package com.model.lib;

/**
 * The time.
 */
public class Time {
  private final int currentDay;

  public Time() {
    this.currentDay = 0;
  }

  protected Time(int currentDay) {
    this.currentDay = currentDay;
  }

  protected Time advanceDay() {
    return new Time(this.currentDay + 1);
  }

  protected int getCurrentDay() {
    return this.currentDay;
  }
}
