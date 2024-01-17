package com.view;

import com.controller.model.Actions;
import com.controller.model.Language;
import com.controller.model.ListMembersActions;
import com.controller.model.ListMembersResponse;
import com.controller.model.MembersListType;
import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.model.AbstractView;
import com.view.model.ListView;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView implements ListView<ListMembersResponse> {
  // private Language language;
  // private String bundleName;
  private MembersListType type;
  List<Member> memberList;

  /**
   * Creates a new instance of the view.
   *
   * @param language   - the language
   * @param bundleName - the bundle name
   * @param type       - the type of list
   */
  public ListMembersView(Language language, String bundleName, MembersListType type) {
    super(language, bundleName);
    this.type = type;

  }

  @Override
  public void displayMenu(StuffLendingSystem stuffSystem) {
    this.memberList = stuffSystem.getMemberList();
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
  public ListMembersResponse getInput() {

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
        return new ListMembersResponse(ListMembersActions.SELECTEDMEMBER, index);
      } else {
        switch (input) {
          case "a":
            return new ListMembersResponse(ListMembersActions.ADDMEMBER, -1);
          case "x":
          case "X":
          case "q":
          case "Q":
            return new ListMembersResponse(ListMembersActions.EXIT, -1);
          default:
            return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
        }
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
    }
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
    // TODO: Implement this method
    throw new UnsupportedOperationException("Unimplemented method 'displayDetailedMenu'");
  }
}
