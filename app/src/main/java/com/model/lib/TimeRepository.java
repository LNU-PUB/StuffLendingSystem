package com.model.lib;

import com.model.TimeRepositories;

/**
 * The time service.
 */
public class TimeRepository implements TimeRepositories {
  private volatile Time currentTime;

  /**
   * Creates a new instance of the time service.
   */
  public TimeRepository() {
    this.currentTime = new Time();
  }

  /**
   * Deep copy constructor. Creates a new instance of the time service.
   *
   * @param currentTime - The time to copy.
   */
  public TimeRepository(int currentTime) {
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
