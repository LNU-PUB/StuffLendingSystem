package com.view;

import com.controller.model.Language;
import com.controller.model.MainActions;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView {
  // private Language language;

  /**
   * Constructor.
   *
   * @param language - The language to use.
   */
  public MainView(Language language, String bundleName) {
    super(language, bundleName);
  }

  @Override
  public void displayMenu() {
    displayGreeting();

    System.out.println("- " + texts.getString("title") + " -\n");
    for (MainActions actions : MainActions.values()) {
      if (actions != MainActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public com.controller.model.Actions getInput() {

    System.out.print(texts.getString("enter") + ": ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      switch (c) {
        case 'm':
          return MainActions.LISTMEMBERS;
        case 'n':
          return MainActions.LISTMEMBERSDETAIL;
        case 'a':
          return MainActions.ADVANCETIME;
        case 'x':
          return MainActions.QUIT;
        case 'X':
          return MainActions.QUIT;
        case 'q':
          return MainActions.QUIT;
        case 'Q':
          return MainActions.QUIT;
        case '0':
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
