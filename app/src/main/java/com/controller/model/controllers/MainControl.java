package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.actions.MainActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandFactory;
import com.controller.model.util.InputService;
import com.model.Services;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * The controller.
 */
public class MainControl extends AbstractControl {

  private static final String BUNDLE_NAME = "MainView";
  private InputService inputService;
  private final Language language;

  /**
   * Creates a new instance of the controller.
   *
   * @param language          - the language to use.
   * @param inputService      - the input service to use.
   * @param viewFactory       - the view factory to use.
   * @param controllerFactory - the controller factory to use.
   */
  public MainControl(Language language, InputService inputService, ViewFactoryProvider viewFactory,
      ControllerFactoryProvider controllerFactory) {
    super(inputService, viewFactory, controllerFactory);
    this.language = language;
    this.inputService = inputService;
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run(Services service) {
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createMainMenuView(language, BUNDLE_NAME);
    view.cleanScreen();
    view.displayGreeting();
    view.displayMenu(service);
    MainActions action = getInput(view);

    if (action == MainActions.LISTMEMBERS) {
      listMembersControl(service, false);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembersControl(service, true);
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime(service);
    }

    return action != MainActions.QUIT;
  }

  private MainActions getInput(ViewProvider view) {
    view.displayEnterPrompt();
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
    CommandFactory cmdFactory = new CommandFactory();
    Command advTimeCommand = cmdFactory.createAdvanceTimeCommand(); // new AdvanceTimeCommand();
    advTimeCommand.execute(service);
  }

  private void listMembersControl(Services service, boolean detailedList) {
    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createListMemberControl(language, inputService, detailedList,
        getViewFactory(), getControllerFactory());
    while (ctr.run(service)) {
    }
  }
}
