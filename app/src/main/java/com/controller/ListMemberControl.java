package com.controller;

import com.controller.model.AbstractControl;
import com.controller.model.DisplayDataBundle;
import com.controller.model.DisplayDataBundles;
import com.controller.model.InputService;
import com.controller.model.Language;
import com.controller.model.ListMembersResponse;
import com.controller.model.actions.ListMembersActions;
import com.controller.model.commands.AddMemberCommand;
import com.controller.model.commands.Command;
import com.model.Member;
import com.model.Services;
import com.model.lib.BasicMemberData;
import com.view.model.View;
import com.view.model.ViewFactory;
import com.view.model.ViewFactoryProvider;

/**
 * The control for listing members.
 */
public class ListMemberControl extends AbstractControl {
  private static final String BUNDLE_NAME = "ListMembersView";
  private final Language language;
  private View view;
  private final InputService inputService;
  private final boolean detailedList;
  private final ViewFactoryProvider viewFactory;

  /**
   * Creates a new instance of the control.
   *
   * @param language     - the language to use.
   * @param inputService - the input service to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMemberControl(Language language, InputService inputService,
      boolean detailedList, ViewFactoryProvider viewFactory) {
    super(inputService);
    this.language = language;
    this.inputService = inputService;
    this.detailedList = detailedList;
    this.viewFactory = viewFactory;
    this.view = viewFactory.createListMembersView(language, BUNDLE_NAME, detailedList);
  }

  @Override
  public boolean run(Services service) {
    DisplayDataBundles bundle = new DisplayDataBundle(service.getAllMembers(), null, null, null);
    view.displayMenu(bundle);
    ListMembersActions action = ListMembersActions.UNKNOWN;

    try {
      ListMembersResponse response = detailedList ? getStaticInput() : getInput();
      action = response.getAction();

      if (action == ListMembersActions.SELECTEDMEMBER) {
        Member member = getMemberByIndex(service.getAllMembers(), response.getIndex());
        viewMember(service, member);
      } else if (action == ListMembersActions.ADDMEMBER) {
        addMember(service);
      }
    } catch (Exception e) {
      view.displayError(e.getMessage());
    }

    return action != ListMembersActions.EXIT;
  }

  private Member getMemberByIndex(Iterable<Member> memberList, int index) {
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

  private ListMembersResponse getInput() {
    view.displayPrompt();
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

  private ListMembersResponse getStaticInput() {
    view.displayPrompt("Exit menu press enter: ");

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

    MemberControl memberControl = new MemberControl(language, inputService, member, viewFactory);
    while (memberControl.run(service)) {
    }
  }

  private void addMember(Services service) {
    ViewFactory factory = new ViewFactory();
    View dataView = factory.createEntityCreationView(language, "BasicMemberData");

    BasicMemberData memberData = getAllMemberData(dataView, service);
    Command addMember = new AddMemberCommand(memberData);
    addMember.execute(service);
  }
}
