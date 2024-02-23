package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.actions.MemberActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandFactory;
import com.controller.model.util.InputService;
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

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param member       - the member to operate on.
   */
  public MemberControl(Language language, InputService inputService, Member member,
      ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    super(inputService, member, viewFactory, controllerFactory);
    this.inputService = inputService;
    this.language = language;
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run(Services service) {
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createMemberView(language, BUNDLE_NAME, getMember());
    view.displayMenu(service);
    MemberActions action = getInput(service, view);

    if (action == MemberActions.DELETEMEMBER) {
      deleteMember(service);
    } else if (action == MemberActions.EDITMEMBER) {
      editMember(service, view);
    } else if (action == MemberActions.LISTITEMS) {
      listItems(service);
    } else if (action == MemberActions.LISTALLITEMS) {
      listAllItems(service);
    } else if (action == MemberActions.LENDITEM) {
      lendNewItem(service);
    }

    return action != MemberActions.EXIT;
  }

  private MemberActions getInput(Services service, ViewProvider view) {
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
    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createLendItemControl(language, inputService, getMember(), getViewFactory(), factory);

    while (ctr.run(service)) {
    }
  }

  private void listItems(Services service) {
    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createListItemsControl(language, inputService, false, getMember(), getViewFactory(), factory);
    while (ctr.run(service)) {
    }
  }

  private void listAllItems(Services service) {
    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createListItemsControl(language, inputService, true, null, getViewFactory(), factory);
    while (ctr.run(service)) {
    }
  }

  private void deleteMember(Services service) {
    CommandFactory cmdFactory = new CommandFactory();
    Command deleteMember = cmdFactory.createDeleteMemberCommand(getMember());

    if (deleteMember.execute(service)) {
      resetMember();
    }

    refreshMemberData(service);
  }

  private void editMember(Services service, ViewProvider view) {
    Member member = getMember();
    BasicMemberData memberData = getAllMemberData(view, service);
    CommandFactory cmdFactory = new CommandFactory();
    Command editMember = cmdFactory.createEditMemberCommand(memberData, getMember());
    if (editMember.execute(service)) {
      Member newMember = new Member(member.getId(), memberData.getName(), memberData.getEmail(),
          memberData.getMobile(), member.getMemberCreationDay());
      setMember(newMember);
    }

    refreshMemberData(service);
  }
}
