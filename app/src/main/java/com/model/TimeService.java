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

  /**
   * Deep copy constructor. Creates a new instance of the time service.
   *
   * @param currentTime - The time to copy.
   */
  public TimeService(int currentTime) {
    this.currentTime = new Time(currentTime);
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
