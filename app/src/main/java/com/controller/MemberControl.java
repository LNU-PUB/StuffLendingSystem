package com.controller;

import com.controller.model.AbstractMemberControl;
import com.controller.model.DisplayDataBundle;
import com.controller.model.DisplayDataBundles;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.MemberActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.DeleteMemberCommand;
import com.controller.model.commands.EditMemberCommand;
import com.model.Member;
import com.model.MemberServices;
import com.model.lib.BasicMemberData;
import com.view.model.MenuViewFactory;
import com.view.model.View;
import com.view.model.ViewFactory;

/**
 * The Member controller.
 */
public class MemberControl extends AbstractMemberControl {
  private static final String BUNDLE_NAME = "MemberView";
  private final InputService inputService;
  private final Language language;
  private Member member;
  private MenuViewFactory viewFactory;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member - the member to operate on.
   */
  public MemberControl(Language language, InputService inputService, Member member, MenuViewFactory viewFactory) {
    super(inputService, member);
    this.inputService = inputService;
    this.language = language;
    this.member = member;
    this.viewFactory = viewFactory;
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run(MemberServices memberServ) {
    View view = viewFactory.createMemberView(language, BUNDLE_NAME, member);
    DisplayDataBundles bundle = new DisplayDataBundle(memberServ.getAllMembers(), null, null, null);
    view.displayMenu(bundle);
    MemberActions action = getInput(memberServ);

    if (action == MemberActions.ADDCREDITS) {
      addCredits();
    } else if (action == MemberActions.DELETEMEMBER) {
      deleteMember(memberServ);
    } else if (action == MemberActions.EDITMEMBER) {
      editMember(memberServ);
    } else if (action == MemberActions.LISTITEMS) {
      listItems();
    } else if (action == MemberActions.NEWCONTRACT) {
      createNewContract();
    }

    return action != MemberActions.EXIT;
  }

  private MemberActions getInput(MemberServices memberServ) {
    View view = viewFactory.createMemberView(language, BUNDLE_NAME, member);
    view.displayPrompt();

    String input = inputService.readLine();
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

  private void deleteMember(MemberServices memberServ) {
    Command deleteMember = new DeleteMemberCommand(member);

    if (deleteMember.execute(memberServ)) {
      this.member = null;
    }

    refreshMemberData(memberServ);
  }

  private void editMember(MemberServices memberServ) {
    View dataView = viewFactory.createSimplePromptView(language, "BasicMemberData");

    BasicMemberData memberData = getAllMemberData(dataView, memberServ);
    Command editMember = new EditMemberCommand(memberData, member);
    if (editMember.execute(memberServ)) {
      Member newMember = new Member(member.getId(), memberData.getName(), memberData.getEmail(),
          memberData.getMobile(), member.getMemberCreationDay());
      this.member = newMember;
    }

    refreshMemberData(memberServ);
  }
}
