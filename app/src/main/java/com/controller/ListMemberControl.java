package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.ListMembersResponse;
import com.controller.model.actions.ListMembersActions;
import com.controller.model.commands.AddMemberCommand;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandExecutor;
import com.model.Member;
import com.model.MemberRepository;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The control for listing members.
 */
public class ListMemberControl implements Control {
  private static final String BUNDLE_NAME = "ListMembersView";
  private MemberRepository memberRepo;
  private View view;
  List<Member> memberList;
  Member selectedMember;
  private final InputService inputService;
  private final ControllerArguments args;
  private final boolean detailedList;
  private final Command addMemberCommand;
  private final CommandExecutor commandExecutor;

  /**
   * Creates a new instance of the control.
   *
   * @param args - the controller arguments.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMemberControl(ControllerArguments args, boolean detailedList) {
    this.args = args;
    this.memberRepo = args.getMemberRepo();
    this.inputService = args.getInputService();
    this.detailedList = detailedList;
    this.addMemberCommand = new AddMemberCommand(args);
    this.commandExecutor = new CommandExecutor();
    createMemberList();
    this.view = createView(args, detailedList);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args, boolean detailedList) {
    ViewFactory factory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
        args.getLanguage());
    return factory.createListMembersView(viewArgs, detailedList);
  }

  private void createMemberList() {
    memberList = memberRepo.getMembers();
  }

  @Override
  public boolean run() {
    view.displayMenu();

    ListMembersResponse response = detailedList ? getStaticInput() : getInput();
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
    view.displayPrompt();
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

  private ListMembersResponse getStaticInput() {
    view.displayPrompt("Exit menu press enter: ");

    if (inputService.readLine() != null) {
      return new ListMembersResponse(ListMembersActions.EXIT, -1);
    } else {
      return new ListMembersResponse(ListMembersActions.EXIT, -1);
    }
  }

  private void addMember() {
    Command addMember = new AddMemberCommand(args);
    commandExecutor.executeCommand(addMember);
  }

  private void memberControl(int memberIndex) {
    MemberControl memberControl = new MemberControl(this.args, memberIndex);
    while (memberControl.run()) {
    }
  }
}
