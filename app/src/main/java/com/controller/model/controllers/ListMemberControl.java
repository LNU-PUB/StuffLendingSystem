package com.controller.model.controllers;

import com.controller.ControllerFactoryProvider;
import com.controller.model.Language;
import com.controller.model.actions.ListMembersActions;
import com.controller.model.commands.Command;
import com.controller.model.commands.CommandFactory;
import com.controller.model.util.InputService;
import com.controller.model.util.ListMembersResponse;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicMemberData;
import com.view.ViewFactoryProvider;
import com.view.ViewProvider;

/**
 * The control for listing members.
 */
public class ListMemberControl extends AbstractControl {
  private static final String BUNDLE_NAME = "ListMembersView";
  private final Language language;
  private final InputService inputService;
  private final boolean detailedList;

  /**
   * Creates a new instance of the control.
   *
   * @param language          - the language to use.
   * @param inputService      - the input service to use.
   * @param detailedList      - true if the list should be detailed, false if not.
   * @param viewFactory       - the view factory to use.
   * @param controllerFactory - the controller factory to use.
   */
  public ListMemberControl(Language language, InputService inputService,
      boolean detailedList, ViewFactoryProvider viewFactory, ControllerFactoryProvider controllerFactory) {
    super(inputService, viewFactory, controllerFactory);
    this.language = language;
    this.inputService = inputService;
    this.detailedList = detailedList;
  }

  @Override
  public boolean run(Services service) {
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createListMembersView(language, BUNDLE_NAME, detailedList);
    view.displayMenu(service);
    ListMembersActions action = ListMembersActions.UNKNOWN;

    try {
      ListMembersResponse response = detailedList ? getStaticInput(view) : getInput(view);
      action = response.getAction();

      if (action == ListMembersActions.SELECTEDMEMBER) {
        Iterable<Member> memberList = language == Language.ENG
            ? service.getMembersSortedBy(true, true)
            : service.getMembersSortedBy(false, true);
        Member member = getMemberByIndex(memberList, response.getIndex(), view);
        viewMember(service, member);
      } else if (action == ListMembersActions.ADDMEMBER) {
        addMember(service);
      }
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }

    return action != ListMembersActions.EXIT;
  }

  private Member getMemberByIndex(Iterable<Member> memberList, int index, ViewProvider view) {
    int currentIndex = 0;

    for (Member member : memberList) {
      if (currentIndex == index) {
        return member;
      }

      currentIndex++;
    }
    view.displayError("Invalid index: " + index);
    return null;
  }

  private ListMembersResponse getInput(ViewProvider view) {
    view.displayEnterPrompt();
    String userInput = inputService.readLine();

    if (userInput == null || userInput.isEmpty()) {
      return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
    }

    userInput = userInput.trim();

    if (isNumericInteger(userInput)) {
      int index = Integer.parseInt(userInput);
      return new ListMembersResponse(ListMembersActions.SELECTEDMEMBER, index);
    }

    for (ListMembersActions action : ListMembersActions.values()) {
      if (userInput.equalsIgnoreCase(action.getSelector().trim())) {
        return new ListMembersResponse(action, -1);
      }
    }

    return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
  }

  private ListMembersResponse getStaticInput(ViewProvider view) {
    view.displayString("Exit menu press enter: ");

    if (inputService.readLine() != null) {
      return new ListMembersResponse(ListMembersActions.EXIT, -1);
    } else {
      return new ListMembersResponse(ListMembersActions.EXIT, -1);
    }
  }

  private void viewMember(Services service, Member member) {
    if (member == null) {
      return;
    }

    ControllerFactoryProvider factory = getControllerFactory();
    Control ctr = factory.createMemberControl(language, inputService, member, getViewFactory(), getControllerFactory());
    while (ctr.run(service)) {
    }
  }

  private void addMember(Services service) {
    ViewFactoryProvider factory = getViewFactory();
    ViewProvider view = factory.createEntityCreationView(language, "BasicMemberData");

    BasicMemberData memberData = getAllMemberData(view, service);
    CommandFactory cmdFactory = new CommandFactory();
    Command addMember = cmdFactory.createAddMemberCommand(memberData); // new AddMemberCommand(memberData);
    addMember.execute(service);
  }
}
