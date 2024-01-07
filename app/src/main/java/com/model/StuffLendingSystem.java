package com.model;

/**
 * The stuff lending system.
 */
public class StuffLendingSystem {
  /**
   * The time.
   */
  protected class Time {
    private int time;

    private Time() {
      this.time = 0;
    }

    private void advanceTime() {
      this.time++;
    }

    public int getTime() {
      return this.time;
    }
  }

  private Time time;

  public StuffLendingSystem() {
    this.time = new Time();
  }

  public int getTime() {
    return this.time.getTime();
  }

  public void advanceTime() {
    this.time.advanceTime();
  }
}
