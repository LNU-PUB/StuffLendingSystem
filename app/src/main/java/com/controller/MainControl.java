package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.MainActions;
import com.controller.model.MembersListType;
import com.model.Member;
import com.model.StuffLendingSystem;
// import com.view.ListMembersView;
import com.view.MainView;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The controller.
 */
public class MainControl implements Control {

  private StuffLendingSystem stuffSystem;
  private MainView view;
  private InputService inputService;
  // private ListMemberControl listMemberControl;
  private Language language;
  private List<Member> memberList;

  /**
   * Creates a new instance of the controller.
   *
   * @param args - the controller arguments.
   */
  public MainControl(ControllerArguments args) {
    this.stuffSystem = args.getStuffLendingSystem();
    this.view = (MainView) args.getView();
    this.language = args.getLanguage();
    this.inputService = args.getInputService();
    memberList = stuffSystem.getMemberList();
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
      listMembers(MembersListType.LIST);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembers(MembersListType.DETAILED);
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

  private void listMembers(MembersListType type) {
    System.out.println("List members");
    // ViewArguments viewArgs = new ViewArguments(this.stuffSystem,
    // this.inputService, "MemberView", this.language);
    // ListMembersView view = new ListMembersView(viewArgs, type);
    // listMemberControl = new ListMemberControl(this.stuffSystem, view);
    // while (listMemberControl.run()) {
    // }
  }
}
