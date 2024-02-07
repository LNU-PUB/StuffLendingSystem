package com.controller;

import com.controller.model.Control;
import com.controller.model.DisplayDataBundle;
import com.controller.model.DisplayDataBundles;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.MainActions;
import com.controller.model.commands.AdvanceTimeCommand;
import com.controller.model.commands.Command;
import com.model.Services;
import com.view.model.View;
import com.view.model.ViewFactoryProvider;
import java.util.List;

/**
 * The controller.
 */
public class MainControl implements Control {

  private static final String BUNDLE_NAME = "MainView";
  private InputService inputService;
  private final Language language;
  private final ViewFactoryProvider viewFactory;
  private final View view;

  /**
   * Creates a new instance of the controller.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   */
  public MainControl(Language language, InputService inputService, ViewFactoryProvider viewFactory) {
    this.language = language;
    this.inputService = inputService;
    this.viewFactory = viewFactory;
    this.view = viewFactory.createMainMenuView(language, BUNDLE_NAME);
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run(Services service) {
    DisplayDataBundles bundle = new DisplayDataBundle(null, null, null, null);
    view.displayMenu(bundle);
    MainActions action = getInput();

    if (action == MainActions.LISTMEMBERS) {
      listMembersControl(service, false);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembersControl(service, true);
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime(service);
    }

    return action != MainActions.QUIT;
  }

  private MainActions getInput() {
    view.displayPrompt();
    String userInput = inputService.readLine();

    if (userInput != null && userInput.length() == 1) {
      userInput = userInput.trim();
      char inputChar = userInput.charAt(0);
      List<Character> validSelectors = MainActions.UNKNOWN.getValidSelectors();
      if (validSelectors.contains(inputChar)) {
        for (MainActions action : MainActions.values()) {
          if (action.getSelector() == inputChar) {
            return action;
          }
        }
      }
    }

    view.displayError("Invalid selection");
    return MainActions.UNKNOWN;
  }

  private void advanceTime(Services service) {
    Command advTimeCommand = new AdvanceTimeCommand();
    advTimeCommand.execute(service);
  }

  private void listMembersControl(Services service, boolean detailedList) {
    ListMemberControl listMemberControl = new ListMemberControl(language, inputService, detailedList, viewFactory);
    while (listMemberControl.run(service)) {
    }
  }
}
