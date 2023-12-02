package view;

import controller.model.MemberActions;

/**
 * Responsible for displaying information to the user.
 */
public class MemberView extends AbstractView{

  public MemberView() {
    super();
  }

  @Override
  public void displayMenu() {
    displayGreeting();
    System.out.println("- Member Menu -\n");
    for (MemberActions actions : MemberActions.values()) {
      if (actions != MemberActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + actions.getName());
      }
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public controller.model.Actions getInput() {

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

}
