package com.controller;

import com.controller.model.AdvanceTimeCommand;
import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.MainActions;
import com.model.Member;
import com.model.MemberRepository;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The controller.
 */
public class MainControl implements Control {

  private static final String BUNDLE_NAME = "MainView";
  private MemberRepository memberRepo;
  private View view;
  private InputService inputService;
  private AdvanceTimeCommand advTimeCommand;
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
    this.memberRepo = args.getMemberRepo();
    this.language = args.getLanguage();
    this.inputService = args.getInputService();
    this.advTimeCommand = new AdvanceTimeCommand(args.getTimeService());
    this.memberList = memberRepo.getMembers();
    this.view = createView(args);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args) {
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
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
    MainActions action = getInput();

    if (action == MainActions.LISTMEMBERS) {
      listMembersControl(false);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembersControl(true);
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime();
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

  private void advanceTime() {
    advTimeCommand.execute();
  }

  private void listMembersControl(boolean detailedList) {
    ListMemberControl listMemberControl = new ListMemberControl(this.args, detailedList);
    while (listMemberControl.run()) {
    }
  }
}
