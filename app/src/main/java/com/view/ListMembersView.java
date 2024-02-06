package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.model.Member;
import com.view.model.AbstractView;
import java.util.Collection;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  private final boolean detailedList;

  /**
   * Creates a new instance of the view.
   *
   * @param language     - the language to use.
   * @param bundleName   - the bundle name to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMembersView(Language language, String bundleName, boolean detailedList) {
    super(language, bundleName);
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu(DisplayDataBundles bundles) {
    cleanScreen();
    displayGreeting();
    // this.memberList = memberServ.getAllMembers();
    if (detailedList) {
      displayDetailedMenu(bundles.getMembers());
    } else {
      displaySimpleMenu(bundles.getMembers());
    }
  }

  private void displaySimpleMenu(Iterable<Member> memberList) {
    System.out.println("- " + texts.getString("title") + " -\n");
    System.out.println("Members: " + getSizeOfTheMembersList(memberList));
    int index = 0;
    for (Member member : memberList) {
      // String outputString = String.format("%d - %s, (email: %s, credits: %d, Items:
      // %d)", i,
      // member.getName(), member.getEmail(), member.getCredits(),
      // member.getNumberOfItems());
      String outputString = String.format("%d - %s, (email: %s)", index,
          member.getName(), member.getEmail());

      System.out.println(outputString);
      index++;
    }

    System.out.println();
    System.out.println("a - " + texts.getString("addMember"));
    System.out.println("x - " + texts.getString("exit"));
  }

  private void displayDetailedMenu(Iterable<Member> memberList) {
    System.out.println("- " + texts.getString("detailTitle") + " -\n");
    for (Member member : memberList) {

      String outputString = String.format("Name: %s, Email: %s", member.getName(), member.getEmail());
      System.out.println(outputString);
      // for (Item item : member.getItems()) {
      // System.out.println(" Item: " + item.getName() + ", Description: " +
      // item.getDescription());
      // Contract contract = item.getCurrentContract();
      // if (contract != null) {
      // System.out.println(" Lent to: " + contract.getBorrower().getName()
      // + ", Period: Day " + contract.getStartDay() + " to Day " +
      // contract.getEndDay());
      // }
      // }
      System.out.println("---");
    }
  }

  private int getSizeOfTheMembersList(Iterable<Member> memberList) {
    if (memberList instanceof Collection<?>) {
      return ((Collection<?>) memberList).size();
    } else {
      int size = 0;
      for (Member member : memberList) {
        size++;
      }
      return size;
    }
  }
}
