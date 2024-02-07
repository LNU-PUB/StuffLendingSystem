package com.model;

/**
 * The time service.
 */
public interface TimeRepositories {
  /**
   * Get the current day.
   *
   * @return - current day.
   */
  int getDay();

  /**
   * Advance the day.
   */
  void advanceDay();
}
