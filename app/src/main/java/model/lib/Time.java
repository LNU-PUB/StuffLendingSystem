package model.lib;

/**
 * Responsible for keeping track of the time.
 */
public class Time {
  private int day;

  public Time() {
    day = 0;
  }

  public void incrementDay() {
    day++;
  }

  public int getDay() {
    return day;
  }
}
