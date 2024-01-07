package com.view;

import com.controller.model.Language;
import com.controller.model.ListMembersActions;
import com.controller.model.MembersListType;
import com.model.Member;
import com.view.model.AbstractView;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  private Language language;
  private String bundleName;
  private MembersListType type;

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
  public com.controller.model.Actions getInput() {

    System.out.print(texts.getString("enter") + ": ");
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      switch (c) {
        case 'a':
          return ListMembersActions.ADDMEMBER;
        case 'x':
        case 'X':
        case 'q':
        case 'Q':
        case '0':
          return ListMembersActions.EXIT;
        default:
          return ListMembersActions.UNKNOWN;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return ListMembersActions.UNKNOWN;
    }
  }

  private void displayDetailedMenu(List<Member> memberList) {
  }

  private void displaySimpleMenu(List<Member> memberList) {
  }

}
