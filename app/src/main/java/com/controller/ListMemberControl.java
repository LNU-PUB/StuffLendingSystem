package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.InputService;
import com.controller.model.ListMembersResponse;
import com.controller.model.actions.ListMembersActions;
import com.controller.model.commands.AddMemberCommand;
import com.controller.model.commands.Command;
import com.model.Member;
import com.model.MemberRepository;
import com.model.lib.BasicMemberData;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * The control for listing members.
 */
public class ListMemberControl implements Control {
  private static final String BUNDLE_NAME = "ListMembersView";
  private View view;
  List<Member> memberList;
  Member selectedMember;
  private final InputService inputService;
  private final ControllerArguments args;
  private final boolean detailedList;
  ViewFactory viewFactory;
  // private final CommandExecutor commandExecutor;

  /**
   * Creates a new instance of the control.
   *
   * @param args - the controller arguments.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMemberControl(ControllerArguments args, boolean detailedList) {
    this.args = args;
    args.getMemberRepo();
    this.inputService = args.getInputService();
    this.detailedList = detailedList;
    this.viewFactory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
        args.getLanguage());
    this.view = viewFactory.createListMembersView(viewArgs, detailedList);

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

  private void memberControl(int memberIndex) {
    MemberControl memberControl = new MemberControl(this.args, memberIndex);
    while (memberControl.run()) {
    }
  }

  private void addMember() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), "AddMemberView",
        args.getLanguage());
    ViewFactory factory = new ViewFactory();
    View dataView = factory.createEntityCreationView(viewArgs);

    BasicMemberData memberData = getAllMemberData(dataView);
    Command addMember = new AddMemberCommand(args, memberData);
    addMember.execute();
  }

  private BasicMemberData getAllMemberData(View dataView) {
    // data: name, email, mobile, item list, credits.
    String name = getName(dataView);
    String email = getEmail(dataView);
    String mobile = getMobile(dataView);

    // BasicMemberData memberData = new BasicMemberData(name, email, mobile);

    // return args.getMemberRepo().addNewMember(memberData);

    return new BasicMemberData(name, email, mobile);
  }

  private String getName(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("name");
      String name = inputService.readLine();

      if (args.getMemberRepo().validateName(name)) {
        return name;
      }

      dataView.displayError("Invalid Name. Name has to be at least 2 characters long.");
    }
  }

  private String getEmail(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("email");
      String email = inputService.readLine();

      if (args.getMemberRepo().validateEmail(email)) {
        return email;
      }

      dataView.displayError("Invalid Email. Email has to be unique and valid.");
    }
  }

  private String getMobile(View dataView) {
    while (true) {
      InputService inputService = args.getInputService();
      dataView.displayResourcePrompt("mobile");
      String mobile = inputService.readLine();

      if (args.getMemberRepo().validateMobile(mobile)) {
        return mobile;
      }

      dataView.displayError("Invalid Mobile. Mobile has to be unique and valid.");
    }
  }
}
