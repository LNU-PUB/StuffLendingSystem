package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.ListMembersActions;
import com.controller.model.ListMembersResponse;
import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The control for listing members.
 */
public class ListMemberControl implements Control {
  private static final String BUNDLE_NAME = "ListMembersView";
  private StuffLendingSystem stuffSystem;
  private View view;
  List<Member> memberList;
  Member selectedMember;
  private final InputService inputService;
  private final ControllerArguments args;

  /**
   * Creates a new instance of the control.
   *
   * @param args - the controller arguments.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMemberControl(ControllerArguments args, boolean detailedList) {
    this.args = args;
    this.stuffSystem = args.getStuffLendingSystem();
    this.inputService = args.getInputService();
    createMemberList();
    this.view = createView(args, detailedList);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args, boolean detailedList) {
    ViewFactory factory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getStuffLendingSystem(), BUNDLE_NAME,
        args.getLanguage());
    return factory.createListMembersView(viewArgs, detailedList);
  }

  private void createMemberList() {
    memberList = stuffSystem.getMemberList();
  }

  @Override
  public boolean run() {
    view.displayMenu();
    view.displayPrompt();

    ListMembersResponse response = getInput();
    ListMembersActions action = response.getAction();
    int index = response.getIndex();

    if (action == ListMembersActions.SELECTEDMEMBER) {
      memberControl(index);
    } else if (action == ListMembersActions.ADDMEMBER) {
      addMember();
    }

    return action != ListMembersActions.EXIT;
  }

  private ListMembersResponse getInput() {
    String userInput = inputService.readLine();

    if (isNumericInteger(userInput)) {
      int index = Integer.parseInt(userInput);
      return new ListMembersResponse(ListMembersActions.SELECTEDMEMBER, index);
    } else {
      switch (userInput) {
        case "a":
          return new ListMembersResponse(ListMembersActions.ADDMEMBER, -1);
        case "x":
        case "X":
        case "q":
        case "Q":
          return new ListMembersResponse(ListMembersActions.EXIT, -1);
        default:
          return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
      }
    }
  }

  private void addMember() {

  }

  private void memberControl(int memberIndex) {
    MemberControl memberControl = new MemberControl(this.args, memberIndex);
    while (memberControl.run()) {
    }
  }
}
