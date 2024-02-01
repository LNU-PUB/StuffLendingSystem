package com.controller.model.commands;

/**
 * An abstract command class.
 */
public abstract class AbstractCommand implements Command {

  /**
   * Checks if a string is numeric.
   *
   * @param strNum - the string to check.
   * @return - true if the string is numeric, false if not.
   */
  public boolean isNumericInteger(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
