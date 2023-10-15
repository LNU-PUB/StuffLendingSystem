package controller;

import view.model.Command;
import view.model.MenuOption;

/**
 * Class for navigating to a sub menu.
 * Part of the Command Pattern.
 */
public class SubMenuCommand {
  private final ClubAdministration clubAdmin;
  private final MenuOption[] nextMenu;

  public SubMenuCommand(ClubAdministration clubAdmin, MenuOption[] nextMenu) {
    this.clubAdmin = clubAdmin.clone();
    this.nextMenu = nextMenu.clone();
  }

  
  public void executeCommand() {
    clubAdmin.addToMenuStack(nextMenu);
  }
}
