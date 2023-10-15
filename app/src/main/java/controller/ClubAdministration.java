package controller;

import java.util.Stack;
import model.Member;
import model.MemberAdministration;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;
import view.ConsoleUi;
import view.model.MainMenu;
import view.model.MenuOption;


/**
 * Responsible for performing operations on members.
 */
public class ClubAdministration implements Cloneable {
  // private MemberAdministration memberAdmin;
  // private MenuController menuController;
  // private ConsoleUi consoleUi;
  // private final Time time;
  
  private Stack<MenuOption[]> menuStack = new Stack<>();

  /**
   * Constructor.
   *
   * @param strategy - The strategy to use for data handling.
   */
  public ClubAdministration(Time time, DataHandlingStrategy strategy) {
    // this.memberAdmin = new MemberAdministration(strategy);
    // this.menuStack.push(MainMenu.values());
    // this.time = time;
  }

  @Override
  public ClubAdministration clone() {
    try {
      return (ClubAdministration) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  /**
   * Returns the current menu.
   *
   * @return - The current menu.
   */
  public MenuOption[] getCurrentMenu() {
    return menuStack.isEmpty() ? null : menuStack.peek();
  }

  /**
   * Pops the latest menu added out of the menu stack.
   */
  public void exitMenu() {
    if (!menuStack.isEmpty()) {
      menuStack.pop();
    }
  }

  /**
   * Displays the current menu.
   *
   * @param menu - The menu to display.
   */
  public void addToMenuStack(MenuOption[] menu) {
    menuStack.push(menu);
  }

  /**
   * Pops the current menu from the stack.
   */
  public void popMenu() {
    if (!menuStack.isEmpty()) {
      menuStack.pop();
    }
  }

  public void addMember() {
    // memberAdmin.addMember(member);
  }

  public void deleteMember() {
    // memberAdmin.deleteMember(member);
  }
}