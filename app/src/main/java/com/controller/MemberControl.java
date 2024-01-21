package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.MemberActions;
import com.model.StuffLendingSystem;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * The Member controller.
 */
public class MemberControl implements Control {
  private static final String BUNDLE_NAME = "MemberView";
  private final StuffLendingSystem stuffSystem;
  private final int memberIndex;
  private final View view;
  private final ControllerArguments args;
  // private List<Member> members;

  /**
   * Creates a new instance of the control.
   *
   * @param args - the controller arguments.
   * @param memberIndex - the index of the member to operate on.
   */
  public MemberControl(ControllerArguments args, int memberIndex) {
    this.stuffSystem = args.getStuffLendingSystem();
    this.memberIndex = memberIndex;
    this.args = args;
    this.view = createView(args);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args) {
    ViewFactory factory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getStuffLendingSystem(), BUNDLE_NAME,
        args.getLanguage());
    return factory.createMemberView(viewArgs, memberIndex);
  }

  /**
   * Runs the application.
   *
   * @return true if the application should continue, false if the application
   *         should exit.
   */
  public boolean run() {
    view.displayMenu();
    MemberActions action = getInput();

    if (action == MemberActions.VIEWMEMBER) {
      view.displayMenu();
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

  private MemberActions getInput() {
    System.out.print("Enter: ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      switch (c) {
        case 'm':
          return MemberActions.VIEWMEMBER;
        case 'a':
          return MemberActions.ADDMEMBER;
        case 'e':
          return MemberActions.EDITMEMBER;
        case 'd':
          return MemberActions.DELETEMEMBER;
        case 's':
          return MemberActions.SIMPLELISTMEMBERS;
        case 'l':
          return MemberActions.DETAILEDLISTMEMBERS;
        case 'x':
          return MemberActions.EXIT;
        default:
          return MemberActions.UNKNOWN;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return MemberActions.UNKNOWN;
    }
  }

  private void detailedListMembers() {
    System.out.println("Detailed List Members");
  }

  private void simpleListMembers() {
    System.out.println("Simple List Members");
  }

  private void deleteMember() {
    System.out.println("Delete Member");
    updateMember();
  }

  private void editMember() {
    System.out.println("Edit Member");
    updateMember();
  }

  private void addMember() {
    System.out.println("Add Member");
    updateMember();
  }

  private void viewMember() {
    System.out.println("View Member");
  }

  private void updateMember() {
    // stuffSystem.updateMember(member);
  }
}
