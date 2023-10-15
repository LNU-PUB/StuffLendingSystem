package controller;


import java.util.HashMap;
import java.util.Map;
import model.Member;
import model.lib.Time;
import view.model.Command;
import view.model.MemberMenu;

/**
 * Class to handle the Member Menu.
 * Part of the Command Pattern.
 */
public class MemberMenuCommandMapper {
  private final Map<MemberMenu, Command> commandMap = new HashMap<>();

  /**
   * Constructor.
   *
   * @param time - The time object.
   * @param clubAdmin - The club administration object.
   */
  public MemberMenuCommandMapper(Time time, ClubAdministration clubAdmin) {
    commandMap.put(MemberMenu.ADDMEMBER, clubAdmin::addMember);
    commandMap.put(MemberMenu.DELETEMEMEBER, clubAdmin::deleteMember);
    // add more mappings
  }
  
  /**
   * Returns the command mapped to the menu option.
   *
   * @param menuOption - The menu.
   * @return - The command.
   */
  public Command getCommand(MemberMenu menuOption) {
    return commandMap.get(menuOption);
  }

}
