package controller;

import model.menu.Command;

/**
 * Class for navigating to a sub menu.
 * Part of the Command Pattern.
 */
public class SubMenuCommand implements Command {
  private final ClubAdministration clubAdmin;
  private final Enum<?>[] nextMenu;

  public SubMenuCommand(ClubAdministration clubAdmin, Enum<?>[] nextMenu) {
    this.clubAdmin = clubAdmin;
    this.nextMenu = nextMenu;
  }

  @Override
  public void execute() {
    clubAdmin.pushMenu(nextMenu);
  }
}
