package controller;

import java.util.HashMap;
import java.util.Map;

import model.menu.Command;
import model.menu.MainMenu;

class MainMenuCommandMapper {
  private final Map<MainMenu, Command> commandMap = new HashMap<>();

  MainMenuCommandMapper() {
    commandMap.put(MainMenu.MEMBER_MENU, new MemberMenuCommand());
    commandMap.put(MainMenu.ADVANCE_DAYS, new AdvanceDaysCommand());
  }

  public Command getCommand(MainMenu menuOption) {
    return commandMap.get(menuOption);
  }
}