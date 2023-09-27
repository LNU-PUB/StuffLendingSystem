package model;

/**
 * Responsible for keeping track of the time.
 */
public class Time {
  private static Time dayCounter;
  private int day;

  private Time() {
    day = 0;
  }

  /**
   * Returns the instance of the time class.
   *
   * @return - The instance of the time class.
   */
  public static Time getInstance() {
    if (dayCounter == null) {
      dayCounter = new Time();
    }
    return dayCounter;
  }

  public void incrementDay() {
    day++;
  }

  public int getDay() {
    return day;
  }
}
