package controller;

import model.menu.Command;

/**
 * Class for advancing Days.
 * Part of the Command Pattern.
 */
public class AdvanceDaysCommand implements Command {

  @Override
  public void execute() {
    System.out.println("\n*** Advance Days Command ***");
  }

}
