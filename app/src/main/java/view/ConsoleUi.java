package view;


/**
 * Responsible for displaying information to the user.
 */
public class ConsoleUi implements View {
  
  /**
   * Displays a greeting to the user.
   */
  public void displayGreeting() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
    System.out.println("Welcome to the Stuff lending System\n");
  }

  public void mainMenu() {
    displayGreeting();

  }
}
