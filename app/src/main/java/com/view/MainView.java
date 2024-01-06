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
  private ResourceBundle texts;
  private Locale locale;

  /**
   * Constructor.
   *
   * @param language - The language to use.
   */
  public MainView(Language language) {
    super();
    // this.language = language;
    try {
      this.locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
      this.texts = ResourceBundle.getBundle("com.view.MainView", locale);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
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