package com.controller;

import com.controller.model.Control;
import com.controller.model.Language;
import com.controller.model.MainActions;
import com.controller.model.MembersListType;
import com.model.StuffLendingSystem;
import com.view.MemberView;
import com.view.View;

/**
 * The controller.
 */
public class StuffControl implements Control {

  private StuffLendingSystem stuffSystem;
  private View view;
  private MemberControl memberControl;
  Language language;

  /**
   * Creates a new instance of the controller.
   *
   * @param stuffSystem - The stuff system.
   * @param view       - The view.
   * @param language  - The language.
   */
  public StuffControl(StuffLendingSystem stuffSystem, View view, Language language) {
    this.stuffSystem = stuffSystem;
    this.view = view;
    this.language = language;
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run() {
    view.displayMenu();
    MainActions action = (MainActions) view.getInput();

    if (action == MainActions.LISTMEMBERS) {
      listMembers(MembersListType.LIST);
    } else if (action == MainActions.LISTMEMBERSDETAIL) {
      listMembers(MembersListType.DETAILED);
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime();
    }

    return action != MainActions.QUIT;
  }

  private void advanceTime() {
    this.stuffSystem.advanceTime();
  }

  private void listMembers(MembersListType type) {
    MemberView view = new MemberView(language, "MemberView");
    memberControl = new MemberControl(this.stuffSystem, view);
    while (memberControl.run()) {
    }
  }
}
