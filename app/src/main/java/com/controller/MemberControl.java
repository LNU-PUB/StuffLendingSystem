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
import com.model.Services;
import com.model.lib.BasicMemberData;
import com.view.model.View;
import com.view.model.ViewFactoryProvider;

/**
 * The Member controller.
 */
public class MemberControl extends AbstractMemberControl {
  private static final String BUNDLE_NAME = "MemberView";
  private final InputService inputService;
  private final Language language;
  private Member member;
  private ViewFactoryProvider viewFactory;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   */
  public MemberControl(Language language, InputService inputService, Member member, ViewFactoryProvider viewFactory) {
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
  public boolean run(Services service) {
    View view = viewFactory.createMemberView(language, BUNDLE_NAME, member);
    DisplayDataBundles bundle = new DisplayDataBundle(service.getAllMembers(), null, null, null);
    view.displayMenu(bundle);
    MemberActions action = getInput(service);

    if (action == MemberActions.ADDCREDITS) {
      addCredits();
    } else if (action == MemberActions.DELETEMEMBER) {
      deleteMember(service);
    } else if (action == MemberActions.EDITMEMBER) {
      editMember(service);
    } else if (action == MemberActions.LISTITEMS) {
      listItems(service);
    } else if (action == MemberActions.NEWCONTRACT) {
      createNewContract();
    }

    return action != MemberActions.EXIT;
  }

  private MemberActions getInput(Services service) {
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

  private void listItems(Services service) {
    ListItemsControl listItemsControl = new ListItemsControl(language, inputService, true, viewFactory, member);
    while (listItemsControl.run(service)) {
    }
  }

  private void addCredits() {
    throw new UnsupportedOperationException("Unimplemented method 'addCredits'");
  }

  private void deleteMember(Services service) {
    Command deleteMember = new DeleteMemberCommand(member);

    if (deleteMember.execute(service)) {
      this.member = null;
    }

    refreshMemberData(service);
  }

  private void editMember(Services service) {
    View dataView = viewFactory.createSimplePromptView(language, "BasicMemberData");

    BasicMemberData memberData = getAllMemberData(dataView, service);
    Command editMember = new EditMemberCommand(memberData, member);
    if (editMember.execute(service)) {
      Member newMember = new Member(member.getId(), memberData.getName(), memberData.getEmail(),
          memberData.getMobile(), member.getMemberCreationDay());
      this.member = newMember;
    }

    refreshMemberData(service);
  }
}
