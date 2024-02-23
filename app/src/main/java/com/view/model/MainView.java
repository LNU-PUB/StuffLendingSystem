package com.view.model;

import com.controller.model.Language;
import com.controller.model.actions.MainActions;
import com.model.Services;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView {
  Language language;

  /**
   * Creates a new instance of the view.
   *
   * @param language - the view arguments
   */
  public MainView(Language language, String bundleName) {
    super(language, bundleName);
    this.language = language;
  }

  @Override
  public void displayMenu(Services service) {
    System.out.println("- " + texts.getString("title") + " -\n");

    if (language == Language.ENG) {
      displayMenuEnglish();
    } else {
      displayMenuOthers();
    }
  }

  private void displayMenuEnglish() {
    for (MainActions actions : MainActions.values()) {
      if (actions != MainActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  private void displayMenuOthers() {
    try {
      MainActions[] actionsArray = MainActions.values();
      for (int i = actionsArray.length - 1; i >= 0; i--) {
        MainActions action = actionsArray[i];
        if (action != MainActions.UNKNOWN) {
          List<String> numberSelectors = dataFormatter.selectorEncoder(action.getSelector());
          StringBuilder selectors = new StringBuilder();
          for (String selector : numberSelectors) {
            selectors.append(selector);
          }
          System.out.println(selectors.toString() + " - " + texts.getString(action.getName()));
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(texts.getString("error") + ": Unknown language: "
          + language + "\n message: " + e.getMessage());
      System.out.println(texts.getString("error") + ": Using default language: " + Language.ENG.getLanguage());
      // this.language = Language.ENG;
      // setResourceBundle(language);
      // displayMenuEnglish();
    }
  }

}
