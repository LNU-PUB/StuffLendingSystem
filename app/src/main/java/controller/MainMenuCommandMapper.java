package controller;

import java.util.HashMap;
import java.util.Map;
import model.Member;
import model.lib.Time;
import view.model.Command;
import view.model.MainMenu;
import view.model.MemberMenu;

class MainMenuCommandMapper {
  private final Map<MainMenu, Command> commandMap = new HashMap<>();

  MainMenuCommandMapper(Time time, ClubAdministration clubAdmin) {
    commandMap.put(MainMenu.MEMBER_MENU, () -> clubAdmin.addToMenuStack(MemberMenu.values()));
    commandMap.put(MainMenu.ADVANCE_DAYS, new AdvanceDaysCommand(time));
  }

  public Command getCommand(MainMenu menuOption) {
    return commandMap.get(menuOption);
  }
}