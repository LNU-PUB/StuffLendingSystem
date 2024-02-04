package com.model;

/**
 * The time service.
 */
public class TimeService {
  private volatile Time currentTime;

  /**
   * Creates a new instance of the time service.
   */
  public TimeService() {
    this.currentTime = new Time();
  }

  public int getDay() {
    return currentTime.getCurrentDay();
  }

  /**
   * Advances the day.
   */
  public void advanceDay() {
    this.currentTime = currentTime.advanceDay();
  }
}
