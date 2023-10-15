package controller;

import view.model.Command;
import view.model.MainMenu;
import view.model.MemberMenu;
import view.model.MenuOption;

/**
 * Class to handle the menus.
 */
public class MenuController {
  private MainMenuCommandMapper mainMapper;
  private MemberMenuCommandMapper memberMapper;
  
  /**
   * Constructor.
   *
   * @param mainMapper - The main menu command mapper.
   * @param memberMapper - The member menu command mapper.
   */
  public MenuController(MainMenuCommandMapper mainMapper, MemberMenuCommandMapper memberMapper) {
    this.mainMapper = mainMapper;
    this.memberMapper = memberMapper;
  }

  /**
   * Executes the command mapped to the menu option.
   *
   * @param menuOption - The menu option.
   */
  public void executeCommand(MenuOption menuOption) {
    Command command = null;
    if (menuOption instanceof MainMenu) {
      command = mainMapper.getCommand((MainMenu) menuOption);
    } else if (menuOption instanceof MemberMenu) {
      command = memberMapper.getCommand((MemberMenu) menuOption);
    }
    if (command != null) {
      command.execute();
    }
  }
}
