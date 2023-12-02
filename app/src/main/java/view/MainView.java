package view;

import controller.model.MainActions;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView {

  public MainView() {
    super();
  }

  @Override
  public void displayMenu() {
    displayGreeting();
    System.out.println("- Main Menu -\n");
    for (MainActions actions : MainActions.values()) {
      if (actions != MainActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + actions.getName());
      }
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public controller.model.Actions getInput() {
    
    System.out.print("Enter: ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      switch (c) {
        case 'm':
          return MainActions.MEMBER;
        case 'n':
          return MainActions.NEWCONTRACT;
        case 'a':
          return MainActions.ADVANCETIME;
        case 'q':
          return MainActions.QUIT;
        default:
          return MainActions.UNKNOWN;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return MainActions.UNKNOWN;
    }
  }
}
