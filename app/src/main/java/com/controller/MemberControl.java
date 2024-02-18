package com.controller;

import com.controller.model.AbstractControl;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.actions.MemberActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.DeleteMemberCommand;
import com.controller.model.commands.EditMemberCommand;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicMemberData;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * The Member controller.
 */
public class MemberControl extends AbstractControl {
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
    ViewProvider view = viewFactory.createMemberView(language, BUNDLE_NAME, member);
    view.displayMenu(service);
    MemberActions action = getInput(service);

    if (action == MemberActions.DELETEMEMBER) {
      deleteMember(service);
    } else if (action == MemberActions.EDITMEMBER) {
      editMember(service);
    } else if (action == MemberActions.LISTITEMS) {
      listItems(service);
    } else if (action == MemberActions.LISTALLITEMS) {
      listAllItems(service);
    } else if (action == MemberActions.LENDITEM) {
      lendNewItem(service);
    }

    return action != MemberActions.EXIT;
  }

  private MemberActions getInput(Services service) {
    ViewProvider view = viewFactory.createMemberView(language, BUNDLE_NAME, member);
    view.displayEnterPrompt();

    String input = inputService.readLine();
    if (input == null || input.isEmpty()) {
      return MemberActions.UNKNOWN;
    }

    input = input.trim();

    for (MemberActions action : MemberActions.values()) {
      if (input.equalsIgnoreCase(action.getSelector().trim())) {
        return action;
      }
    }

    return MemberActions.UNKNOWN;
  }

  private void lendNewItem(Services service) {
    LendItemControl lendItemControl = new LendItemControl(language, inputService, member, viewFactory);
    while (lendItemControl.run(service)) {
    }
  }

  private void listItems(Services service) {
    ListItemsControl listItemsControl = new ListItemsControl(language, inputService, false, viewFactory, member);
    while (listItemsControl.run(service)) {
    }
  }

  private void listAllItems(Services service) {
    ListItemsControl listItemsControl = new ListItemsControl(language, inputService, true, viewFactory, null);
    while (listItemsControl.run(service)) {
    }
  }

  private void deleteMember(Services service) {
    Command deleteMember = new DeleteMemberCommand(member);

    if (deleteMember.execute(service)) {
      this.member = null;
    }

    refreshMemberData(service);
  }

  private void editMember(Services service) {
    ViewProvider dataView = viewFactory.createSimplePromptView(language, "BasicMemberData");

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
