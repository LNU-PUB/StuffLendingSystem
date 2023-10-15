package controller;

import model.lib.HardCodeDataHandler;
import model.lib.Time;
import view.ConsoleUi;
import view.model.MainMenu;

/**
 * Responsible for staring the application.
 */
public class App {

  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    Time time = new Time();
    ClubAdministration clubAdmin = new ClubAdministration(time, new HardCodeDataHandler());
    MainMenuCommandMapper mainMapper = new MainMenuCommandMapper(time, clubAdmin);
    MemberMenuCommandMapper memberMapper = new MemberMenuCommandMapper(time, clubAdmin);
    MenuController menuController = new MenuController(mainMapper, memberMapper);
    ConsoleUi consoleUi = new ConsoleUi(clubAdmin, menuController);
    boolean exit = false;

    clubAdmin.addToMenuStack(MainMenu.values());

    while (!exit) {
      consoleUi.displayMenu();
      consoleUi.getUserInputAndExecute();
      if (clubAdmin.getCurrentMenu() == null) {
        exit = true;
      }
    }

    exit();
  }

  private static void exit() {
    System.out.println("\nApplication is closing ...");
    System.exit(0);
  }
}
