package com.view;

import com.controller.model.Actions.MainActions;
import com.view.model.AbstractView;
import com.view.model.ViewArguments;

/**
 * Responsible for displaying information to the user.
 */
public class MainView extends AbstractView {
  /**
   * Creates a new instance of the view.
   *
   * @param viewArgs - the view arguments
   */
  public MainView(ViewArguments viewArgs) {
    super(viewArgs.getLanguage(), viewArgs.getBundleName());
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

  // @Override
  // public Actions getInput() {
  //   displayPrompt();
  //   String input = scanner.readLine().trim();

  //   if (input.length() == 1) {
  //     char inputChar = input.charAt(0);
  //     for (MainActions action : MainActions.values()) {
  //       if (action.getSelector() == inputChar) {
  //         return action;
  //       }
  //     }
  //   }

  //   displayError("Invalid selection");
  //   return MainActions.UNKNOWN;
  // }
}
