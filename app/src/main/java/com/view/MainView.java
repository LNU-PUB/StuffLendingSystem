package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.controller.model.actions.MainActions;
import com.view.model.AbstractView;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView {
  /**
   * Creates a new instance of the view.
   *
   * @param language - the view arguments
   */
  public MainView(Language language, String bundleName) {
    super(language, bundleName);
  }

  @Override
  public void displayMenu(DisplayDataBundles bundle) {
    displayGreeting();

    System.out.println("- " + texts.getString("title") + " -\n");
    for (MainActions actions : MainActions.values()) {
      if (actions != MainActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }
}
