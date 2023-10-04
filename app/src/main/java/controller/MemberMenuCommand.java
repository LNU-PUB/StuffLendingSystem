package controller;

import model.menu.Command;

/**
 * Class to handle the Member Menu.
 * Part of the Command Pattern.
 */
public class MemberMenuCommand implements Command {

  @Override
  public void execute() {
    System.out.println("\n*** Member Menu Command ***");
  }

}
