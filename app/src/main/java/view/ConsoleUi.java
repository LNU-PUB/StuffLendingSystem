package view;

/**
 * Responsible for displaying information to the user.
 */
public class ConsoleUi {
  
  public ConsoleUi() { }

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

}
