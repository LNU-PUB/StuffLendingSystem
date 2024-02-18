package com.controller;

import com.controller.model.AbstractControl;
import com.controller.model.DisplayDataBundle;
import com.controller.model.DisplayDataBundles;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.MainActions;
import com.controller.model.commands.AdvanceTimeCommand;
import com.controller.model.commands.Command;
import com.model.Services;
import com.view.model.ViewProvider;
import com.view.model.ViewFactoryProvider;

/**
 * The controller.
 */
public class MainControl extends AbstractControl {

  private static final String BUNDLE_NAME = "MainView";
  private InputService inputService;
  private final Language language;
  private final ViewFactoryProvider viewFactory;
  private final ViewProvider view;

  /**
   * Creates a new instance of the controller.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   */
  public MainControl(Language language, InputService inputService, ViewFactoryProvider viewFactory) {
    super(inputService);
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
    // DisplayDataBundles bundle = new DisplayDataBundle(null, null, null, null);
    // view.displayMenu(bundle);
    view.displayMenu(service);
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

    if (userInput == null || userInput.isEmpty()) {
      return MainActions.UNKNOWN;
    }

    userInput = userInput.trim();

    try {
      if (language != Language.ENG) {
        userInput = dataFormatter.selectorDecoder(userInput);
      }
      
      for (MainActions action : MainActions.values()) {
        if (userInput.equalsIgnoreCase(action.getSelector().trim())) {
          return action;
        }
      }

    } catch (IllegalArgumentException e) {
      view.displayError(e.getMessage());
    }

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
