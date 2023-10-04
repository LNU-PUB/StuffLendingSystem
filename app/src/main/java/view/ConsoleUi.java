package view;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Responsible for displaying information to the user.
 */
public class ConsoleUi {
  private final Scanner sc;

  public ConsoleUi() {
    this.sc = new Scanner(System.in, StandardCharsets.UTF_8.name());
  }

  /**
   * Displays data to the user.
   *
   * @param data - The data to be displayed.
   */
  public void displayData(String data) {
    System.out.println(data);
  }

  /**
   * Displays multiple rows of information.
   *
   * @param prompts - The data to be displayed.
   * @return - The user data entered.
   */
  public String getUserInput(String[] prompts) {
    for (String prompt : prompts) {
      System.out.println(prompt);
    }
    return System.console().readLine();
  }

  /**
   * Displays a single row of information.
   *
   * @param prompt - The data to be displayed.
   * @return - The user data entered.
   */
  public String getUserInput(String prompt) {
    System.out.println(prompt);
    return System.console().readLine();
  }

  public void menu(String menuName, String[] menuEntries) {
    System.out.println("\n*** " + menuName + " ***");
    for (String menuEntry : menuEntries) {
      System.out.println(menuEntry);
    }
  }

  public String getString(String prompt) {
    System.out.print(prompt);
    return sc.next();
  }

}
