package com.controller;

import com.controller.model.Control;
import com.controller.model.ControllerArguments;
import com.controller.model.actions.MemberActions;
import com.model.Member;
import com.model.MemberRepository;
import com.view.ViewFactory;
import com.view.model.View;
import com.view.model.ViewArguments;

/**
 * The Member controller.
 */
public class MemberControl implements Control {
  private static final String BUNDLE_NAME = "MemberView";
  private final MemberRepository memberRepo;
  private final Member member;
  private final View view;
  private final ControllerArguments args;
  // private List<Member> members;

  /**
   * Creates a new instance of the control.
   *
   * @param args        - the controller arguments.
   * @param memberIndex - the index of the member to operate on.
   */
  public MemberControl(ControllerArguments args, Member member) {
    this.memberRepo = args.getMemberRepo();
    this.member = member;
    this.args = args;
    this.view = createView(args);
  }

  // Target for refactoring into AbstractControl class.
  private View createView(ControllerArguments args) {
    ViewFactory factory = new ViewFactory();
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), BUNDLE_NAME,
        args.getLanguage());
    return factory.createMemberView(viewArgs, member);
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

    if (action == MemberActions.ADDCREDITS) {
      addCredits();
    } else if (action == MemberActions.DELETEMEMBER) {
      deleteMember();
    } else if (action == MemberActions.EDITMEMBER) {
      editMember();
    } else if (action == MemberActions.LISTITEMS) {
      listItems();
    } else if (action == MemberActions.NEWCONTRACT) {
      newContract();
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
        case 'e':
          return MemberActions.EDITMEMBER;
        case 'd':
          return MemberActions.DELETEMEMBER;
        case 'c':
          return MemberActions.ADDCREDITS;
        case 'l':
          return MemberActions.LISTITEMS;
        case 'n':
          return MemberActions.NEWCONTRACT;
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

  private void newContract() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'newContract'");
  }

  private void listItems() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listItems'");
  }

  private void addCredits() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addCredits'");
  }

  private void deleteMember() {
    System.out.println("Delete Member");
    updateMember();
  }

  private boolean editMember() {
    ViewArguments viewArgs = new ViewArguments(args.getMemberRepo(), "BasicMemberData",
        args.getLanguage());

    return true; // for development purposes only.
  }

  private void addMember() {
    System.out.println("Add Member");
    updateMember();
  }

  private void viewMember() {
    System.out.println("View Member");
  }

  private void updateMember() {
    // memberRepo.updateMember(member);
  }
}
