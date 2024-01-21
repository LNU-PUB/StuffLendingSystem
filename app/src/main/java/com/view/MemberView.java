package com.view;

import com.controller.model.MemberActions;
import com.view.model.AbstractView;
import com.view.model.ViewArguments;
import java.util.ResourceBundle;

/**
 * Responsible for displaying information to the user.
 */
public class MemberView extends AbstractView {
  private final int memberIndex;

  /**
   * Creates a new instance of the view.
   *
   * @param args - the view arguments.
   * @param memberIndex - the index of the member to display.
   */
  public MemberView(ViewArguments args, int memberIndex) {
    super(args.getLanguage(), args.getBundleName());
    this.memberIndex = memberIndex;
  }


  @Override
  public void displayMenu() {
    displayGreeting();
    
    System.out.println("- " + texts.getString("title") + " -\n");
    for (MemberActions actions : MemberActions.values()) {
      if (actions != MemberActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }

  /*

  Problem in the controller.model.MemberActions enum:
  Fix and fix how the class is viewed.
   * - Members Menu -

v - View Member
a - Add Member
e - Edit Member
d - Delete Member
s - Members Simple List
l - Members Detailed List
Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key exitMembers
        at java.base/java.util.ResourceBundle.getObject(ResourceBundle.java:570)
        at java.base/java.util.ResourceBundle.getString(ResourceBundle.java:527)
        at com.view.MemberView.displayMenu(MemberView.java:33)
   */

  // /**
  //  * Collecting User input.
  //  */
  // @Override
  // public com.controller.model.Actions getInput() {

  //   System.out.print("Enter: ");
  //   try {
  //     int c = System.in.read();
  //     while (c == '\r' || c == '\n') {
  //       c = System.in.read();
  //     }

  //     switch (c) {
  //       case 'm':
  //         return MemberActions.VIEWMEMBER;
  //       case 'a':
  //         return MemberActions.ADDMEMBER;
  //       case 'e':
  //         return MemberActions.EDITMEMBER;
  //       case 'd':
  //         return MemberActions.DELETEMEMBER;
  //       case 's':
  //         return MemberActions.SIMPLELISTMEMBERS;
  //       case 'l':
  //         return MemberActions.DETAILEDLISTMEMBERS;
  //       case 'x':
  //         return MemberActions.EXIT;
  //       default:
  //         return MemberActions.UNKNOWN;
  //     }
  //   } catch (java.io.IOException e) {
  //     System.out.println("" + e);
  //     return MemberActions.UNKNOWN;
  //   }
  // }

}
