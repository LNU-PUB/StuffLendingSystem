package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.MainActions;
import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The controller.
 */
public class MainControl implements Control {

  private static final String BUNDLE_NAME = "MainView";
  private StuffLendingSystem stuffSystem;
  private View view;
  private InputService inputService;
  // private ListMemberControl listMemberControl;
  private Language language;
  private List<Member> memberList;
  private final ControllerArguments args;

  /**
   * Creates a new instance of the controller.
   *
   * @param args - the controller arguments.
   */
  public MainControl(ControllerArguments args) {
    this.args = args;
    this.stuffSystem = args.getStuffLendingSystem();
    this.language = args.getLanguage();
    this.inputService = args.getInputService();
    this.memberList = stuffSystem.getMemberList();
    this.view = createView(args);
  }

  private View createView(ControllerArguments args) {
    ViewArguments viewArgs = new ViewArguments(args.getStuffLendingSystem(), BUNDLE_NAME,
        args.getLanguage());
    ViewFactory factory = new ViewFactory();
    return factory.createMainMenuView(viewArgs);
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run() {
    view.displayMenu();
    view.displayPrompt();
    MainActions action = getInput();

    if (action == MainActions.LISTMEMBERS) {
      listMembers(false);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembers(true);
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime();
    }

    return action != MainActions.QUIT;
  }

  private MainActions getInput() {
    String userInput = inputService.readLine();

    if (userInput != null && userInput.length() == 1) {
      userInput = userInput.trim();
      char inputChar = userInput.charAt(0);
      for (MainActions action : MainActions.values()) {
        if (action.getSelector() == inputChar) {
          return action;
        }
      }
    }

    view.displayError("Invalid selection");
    return MainActions.UNKNOWN;
  }

  private void advanceTime() {
    this.stuffSystem.advanceTime();
  }

  private void listMembers(boolean detailedList) {
    ListMemberControl listMemberControl = new ListMemberControl(this.args, detailedList);
    while (listMemberControl.run()) {
    }
  }
}
