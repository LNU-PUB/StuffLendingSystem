package com.controller.model.controllers;

import com.model.Services;

/**
 * The Controllers interface.
 */
public interface Control {
  public boolean run(Services memberService);

  /**
   * Checks if the string is an integer.
   *
   * @param str - the string to check.
   * @return - true if the string is an integer, false if not.
   */
  default boolean isNumericInteger(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }
    return str.matches("-?\\d+");
  }

  /**
   * Checks if the string is a double.
   *
   * @param str - the string to check.
   * @return - true if the string is a double, false if not.
   */
  default boolean isNumericDouble(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }
    return str.matches("-?\\d+(\\.\\d+)?");
  }
}
