package com.controller;

import com.controller.model.Control;
import com.controller.model.ListMembersActions;
import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.model.View;
import java.util.List;

/**
 * The control for listing members.
 */
public class ListMemberControl implements Control {
  private StuffLendingSystem stuffSystem;
  private View view;
  List<Member> memberList;

  /**
   * Creates a new instance of the control.
   *
   * @param stuffSystem - the stuff lending system
   * @param view        - the view
   */
  public ListMemberControl(StuffLendingSystem stuffSystem, View view) {
    this.stuffSystem = stuffSystem;
    this.view = view;
    createMemberList();
  }

  private void createMemberList() {
    memberList = stuffSystem.getMemberList();
  }

  @Override
  public boolean run() {
    view.displayMenu(memberList);

    ListMembersActions action = (ListMembersActions) view.getInput();

    if (action == ListMembersActions.ADDMEMBER) {
      addMember();
    } 

    return action != ListMembersActions.EXIT;
  }

  private void addMember() {
  }

}
