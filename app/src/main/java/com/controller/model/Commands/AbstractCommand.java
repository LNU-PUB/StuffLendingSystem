package com.controller.model.Commands;

public abstract class AbstractCommand implements Command{
  
  public boolean isNumericInteger(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      int d = Integer.parseInt(strNum);
      d = d + 1;
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
