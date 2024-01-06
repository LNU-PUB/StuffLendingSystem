package com.controller;

import com.controller.model.Control;
import com.controller.model.MainActions;
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

  public StuffControl(StuffLendingSystem stuffSystem, View view) {
    this.stuffSystem = stuffSystem;
    this.view = view;
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

    if (action == MainActions.MEMBER) {
      member();
    } else if (action == MainActions.NEWCONTRACT) {
      newContract();
    } else if (action == MainActions.ADVANCETIME) {
      advanceTime();
    }

    return action != MainActions.QUIT;
  }

  private void advanceTime() {
    System.out.println("Advance Time");
  }

  private void newContract() {
    System.out.println("New Contract");
  }

  private void member() {
    MemberView view = new MemberView();
    memberControl = new MemberControl(this.stuffSystem, view);
    while (memberControl.run()) {
    }
  }
}
