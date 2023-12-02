package controller;

import controller.model.Control;
import controller.model.MemberActions;
import model.StuffLendingSystem;

/**
 * The Member controller.
 */
public class MemberControl implements Control {
  private StuffLendingSystem stuffSystem;
  private view.MemberView view;

  public MemberControl(StuffLendingSystem stuffSystem, view.MemberView view) {
    this.stuffSystem = stuffSystem;
    this.view = view;
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application should exit.
   */
  public boolean run() {
    view.displayMenu();
    MemberActions action = (MemberActions) view.getInput();

    if (action == MemberActions.VIEWMEMBER) {
      viewMember();
    } else if (action == MemberActions.ADDMEMBER) {
      addMember();
    } else if (action == MemberActions.EDITMEMBER) {
      editMember();
    } else if (action == MemberActions.DELETEMEMBER) {
      deleteMember();
    } else if (action == MemberActions.SIMPLELISTMEMBERS) {
      simpleListMembers();
    } else if (action == MemberActions.DETAILEDLISTMEMBERS) {
      detailedListMembers();
    }

    return action != MemberActions.EXIT;
  }

  private void detailedListMembers() {
    System.out.println("Detailed List Members");
  }

  private void simpleListMembers() {
    System.out.println("Simple List Members");
  }

  private void deleteMember() {
    System.out.println("Delete Member");
  }

  private void editMember() {
    System.out.println("Edit Member");
  }

  private void addMember() {
    System.out.println("Add Member");
  }

  private void viewMember() {
    System.out.println("View Member");
  }
}
