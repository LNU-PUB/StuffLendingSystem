package view;

import controller.ClubAdministration;
import controller.MenuController;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import view.model.MenuOption;

/**
 * Responsible for displaying information to the user.
 */
public class ConsoleUi {
  private final Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8.name());
  private final ClubAdministration clubAdmin;
  private final MenuController menuController;

  public ConsoleUi(ClubAdministration clubAdmin, MenuController menuController) {
    this.clubAdmin = clubAdmin.clone();
    this.menuController = menuController;
  }

  /**
   * Displays the main menu.
   */
  public void displayMenu() {
    MenuOption[] currentMenu = clubAdmin.getCurrentMenu();
    if (currentMenu != null) {
      System.out.println("\n*** " + currentMenu[0].getMenuName() + " ***\n");
      for (int i = 0; i < currentMenu.length; i++) {
        System.out.println((i + 1) + ". " + currentMenu[i].getDescription());
      }
      if (currentMenu[0].getMenuName().contains("Main")) {
        System.out.println("q. Quit");
      } else {
        System.out.println("0. Go back");
      }
    }
  }

  /**
   * Gets the user input and executes the command.
   */
  public void getUserInputAndExecute() {
    try {
      System.out.print("\nEnter your choice: ");
      String input = sc.next();
      int choice = input.equalsIgnoreCase("q") ? 0 : Integer.parseInt(input);
      MenuOption[] currentMenu = clubAdmin.getCurrentMenu();
      if (choice >= 1 && choice <= currentMenu.length) {
        menuController.executeCommand(currentMenu[choice - 1]);
      } else if (choice == 0) {
        clubAdmin.exitMenu();
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Invalid input!");
    }
  }
}
