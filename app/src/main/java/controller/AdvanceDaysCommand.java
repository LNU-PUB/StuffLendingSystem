package controller;

import model.lib.Time;
import model.menu.Command;

/**
 * Class for advancing Days.
 * Part of the Command Pattern.
 */
public class AdvanceDaysCommand implements Command {
  private Time time;
  
  public AdvanceDaysCommand(Time time) {
    this.time = time;
  }

  @Override
  public void execute() {
    System.out.println("\n*** Day before: " + time.getDay() + " ***");
    time.incrementDay();
    System.out.println("\n*** Day after: " + time.getDay() + " ***");
  }

}
