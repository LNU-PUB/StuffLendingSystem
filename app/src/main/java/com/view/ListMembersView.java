package com.view;

import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.model.AbstractView;
import com.view.model.ViewArguments;
import java.util.List;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  // private Language language;
  // private String bundleName;
  private final boolean detailedList;
  private List<Member> memberList;
  private final StuffLendingSystem stuffSystem;

  /**
   * Creates a new instance of the view.
   *
   * @param viewArgs - the view arguments
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMembersView(ViewArguments viewArgs, boolean detailedList) {
    super(viewArgs.getLanguage(), viewArgs.getBundleName());
    this.stuffSystem = viewArgs.getStuffSystem();
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu() {
    this.memberList = stuffSystem.getMemberList();
    if (detailedList) {
      displayDetailedMenu(memberList);
    } else {
      displaySimpleMenu(memberList);
    }
  }

  /**
   * Collecting User input.
   */
  // @Override
  // public ListMembersResponse getInput() {

  // System.out.print(texts.getString("enter") + ": ");
  // StringBuilder inputBuilder = new StringBuilder();
  // try {
  // int c = System.in.read();
  // while (c == '\r' || c == '\n') {
  // c = System.in.read();
  // inputBuilder.append((char) c);
  // }

  // String input = inputBuilder.toString().trim();

  // if (isNumericInteger(input)) {
  // int index = Integer.parseInt(input);
  // return new ListMembersResponse(ListMembersActions.SELECTEDMEMBER, index);
  // } else {
  // switch (input) {
  // case "a":
  // return new ListMembersResponse(ListMembersActions.ADDMEMBER, -1);
  // case "x":
  // case "X":
  // case "q":
  // case "Q":
  // return new ListMembersResponse(ListMembersActions.EXIT, -1);
  // default:
  // return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
  // }
  // }
  // } catch (java.io.IOException e) {
  // System.out.println("" + e);
  // return new ListMembersResponse(ListMembersActions.UNKNOWN, -1);
  // }
  // }

  private void displaySimpleMenu(List<Member> memberList) {
    // TODO: Make sure it displays all the data required in the SRS.
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
