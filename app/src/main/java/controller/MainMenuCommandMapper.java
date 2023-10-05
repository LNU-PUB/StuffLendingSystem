package controller;

import java.util.HashMap;
import java.util.Map;
import model.Member;
import model.lib.Time;
import model.menu.Command;
import model.menu.MainMenu;
import model.menu.MemberMenu;

class MainMenuCommandMapper {
  private final Map<MainMenu, Command> commandMap = new HashMap<>();

  MainMenuCommandMapper(Time time, ClubAdministration clubAdmin) {
    commandMap.put(MainMenu.MEMBER_MENU, new SubMenuCommand(clubAdmin, MemberMenu.values()));
    commandMap.put(MainMenu.ADVANCE_DAYS, new AdvanceDaysCommand(time));
  }

  public Command getCommand(MainMenu menuOption) {
    return commandMap.get(menuOption);
  }
}