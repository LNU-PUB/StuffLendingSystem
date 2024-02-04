package com.controller;

import com.controller.model.AbstractMemberControl;
import com.controller.model.ControllerArguments;
import com.controller.model.actions.MemberActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.DeleteMemberCommand;
import com.controller.model.commands.EditMemberCommand;
import com.model.Member;
import com.model.lib.BasicMemberData;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * The Member controller.
 */
public class MemberControl extends AbstractMemberControl {
  private static final String BUNDLE_NAME = "MemberView";
  private Member member;
  private final ControllerArguments args;

  /**
   * Creates a new instance of the control.
   *
   * @param args   - the controller arguments.
   * @param member - the member to operate on.
   */
  public MemberControl(ControllerArguments args, Member member) {
    super(args, member);
    // this.memberRepo = args.getMemberRepo();
    this.member = member;
    this.args = args;
    // this.view = createView(args);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args) {
    ViewFactory factory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getMemberServices(), BUNDLE_NAME,
        args.getLanguage());
    return factory.createMemberView(viewArgs, member);
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run() {
    View view = createView(args);
    view.displayMenu();
    MemberActions action = getInput();

    if (action == MemberActions.ADDCREDITS) {
      addCredits();
    } else if (action == MemberActions.DELETEMEMBER) {
      deleteMember();
    } else if (action == MemberActions.EDITMEMBER) {
      editMember();
    } else if (action == MemberActions.LISTITEMS) {
      listItems();
    } else if (action == MemberActions.NEWCONTRACT) {
      createNewContract();
    }

    return action != MemberActions.EXIT;
  }

  private MemberActions getInput() {
    View view = createView(args);
    view.displayPrompt();

    String input = args.getInputService().readLine();
    if (input == null || input.isEmpty()) {
      return MemberActions.UNKNOWN;
    } else {
      input = input.trim();
    }
    char inputChar = input.length() == 1 ? input.charAt(0) : ' ';

    if (inputChar == ' ') {
      return MemberActions.UNKNOWN;
    }
    if (inputChar == MemberActions.EXIT.getSelector()) {
      return MemberActions.EXIT;
    }
    if (inputChar == MemberActions.ADDCREDITS.getSelector()) {
      return MemberActions.ADDCREDITS;
    }
    if (inputChar == MemberActions.DELETEMEMBER.getSelector()) {
      return MemberActions.DELETEMEMBER;
    }
    if (inputChar == MemberActions.EDITMEMBER.getSelector()) {
      return MemberActions.EDITMEMBER;
    }
    if (inputChar == MemberActions.LISTITEMS.getSelector()) {
      return MemberActions.LISTITEMS;
    }
    if (inputChar == MemberActions.NEWCONTRACT.getSelector()) {
      return MemberActions.NEWCONTRACT;
    }

    return MemberActions.UNKNOWN;
  }

  private void createNewContract() {
    throw new UnsupportedOperationException("Unimplemented method 'createNewContractContract'");
  }

  private void listItems() {
    throw new UnsupportedOperationException("Unimplemented method 'listItems'");
  }

  private void addCredits() {
    throw new UnsupportedOperationException("Unimplemented method 'addCredits'");
  }

  private void deleteMember() {
    Command deleteMember = new DeleteMemberCommand(args , member);

    if (deleteMember.execute()) {
      this.member = null;
    }

    refreshMemberData();
  }

  private void editMember() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberServices(), "BasicMemberData",
        args.getLanguage());
    View dataView = new ViewFactory().createSimplePromptView(viewArgs);

    BasicMemberData memberData = getAllMemberData(dataView);
    Command editMember = new EditMemberCommand(args, memberData, member);
    if (editMember.execute()) {
      Member newMember = new Member(member.getId(), memberData.getName(), memberData.getEmail(),
          memberData.getMobile(), member.getMemberCreationDay());
      this.member = newMember;
    }

    refreshMemberData();
  }
}
