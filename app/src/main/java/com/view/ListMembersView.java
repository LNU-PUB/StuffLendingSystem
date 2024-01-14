package com.view;

import com.controller.model.Actions;
import com.controller.model.Language;
import com.controller.model.ListMembersActions;
import com.controller.model.MemberSelectionListener;
import com.controller.model.MembersListType;
import com.model.Member;
import com.view.model.AbstractView;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  // private Language language;
  // private String bundleName;
  private MembersListType type;
  private MemberSelectionListener listener;

  public ListMembersView(Language language, String bundleName, MembersListType type) {
    super(language, bundleName);
    this.type = type;

  }

  @Override
  public void displayMenu(List<Member> memberList) {
    switch (type) {
      case LIST:
        displaySimpleMenu(memberList);
        break;
      case DETAILED:
        displayDetailedMenu(memberList);
        break;
      default:
        throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
    }
  }

  /**
   * Collecting User input.
   */
  @Override
  public Actions getInput() {

    System.out.print(texts.getString("enter") + ": ");
    StringBuilder inputBuilder = new StringBuilder();
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
        inputBuilder.append((char) c);
      }

      String input = inputBuilder.toString().trim();

      if (isNumericInteger(input)) {
        int index = Integer.parseInt(input);
        if (index >= 0 && index < listener.getMemberList().size()) {
          listener.onMemberSelected(listener.getMemberList().get(index));
        }
        return ListMembersActions.SELECTMEMBER;
      } else {
        switch (input) {
          case "a":
            return ListMembersActions.ADDMEMBER;
          case "x":
          case "X":
          case "q":
          case "Q":
            return ListMembersActions.EXIT;
          default:
            return ListMembersActions.UNKNOWN;
        }
      }
    } catch (
    java.io.IOException e) {
      System.out.println("" + e);
      return ListMembersActions.UNKNOWN;
    }
  }

  public void setMemberSelectionListener(MemberSelectionListener listener) {
    this.listener = listener;
}

  private void displaySimpleMenu(List<Member> memberList) {
    cleanScreen();
    System.out.println("- " + texts.getString("title") + " -\n");
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      System.out.println(Integer.toString(i) + " - " + member.getName());
    }
    System.out.println();
    System.out.println("a - " + texts.getString("addMember"));
    System.out.println("x - " + texts.getString("exit"));
  }

  private void displayDetailedMenu(List<Member> memberList) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayDetailedMenu'");
  }

}
