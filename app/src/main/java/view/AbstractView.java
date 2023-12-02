package view;

/**
 * Input interface.
 */
public abstract class AbstractView implements View {

  public AbstractView() {
  }

  /**
   * Displays a greeting to the user.
   */
  public void displayGreeting() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
    System.out.println("*** Stuff lending System ***\n");
  }

}
