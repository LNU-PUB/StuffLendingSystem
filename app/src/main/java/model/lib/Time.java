package model.lib;

/**
 * Responsible for keeping track of the time.
 */
public class Time {
  private int day;

  /**
   * Constructor.
   */
  public Time() {
    day = 0;
  }

  /**
   * Increments the day.
   */
  public void incrementDay() {
    day++;
  }

  /**
   * Gets the day.
   *
   * @return - The day.
   */
  public int getDay() {
    return day;
  }
}
