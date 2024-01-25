package com.view;

import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.MemberRepository;
import com.view.model.AbstractView;
import com.view.model.ViewArguments;
import java.util.List;

// TODO: Finalize the menu content and implementations of choices adn update the class model.

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  private final boolean detailedList;
  private List<Member> memberList;
  private final MemberRepository memberRepo;

  /**
   * Creates a new instance of the view.
   *
   * @param viewArgs     - the view arguments
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMembersView(ViewArguments viewArgs, boolean detailedList) {
    super(viewArgs.getLanguage(), viewArgs.getBundleName());
    this.memberRepo = viewArgs.getMemberRepo();
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu() {
    cleanScreen();
    displayGreeting();
    this.memberList = memberRepo.getMembers();
    if (detailedList) {
      displayDetailedMenu(memberList);
    } else {
      displaySimpleMenu(memberList);
    }
  }

  private void displaySimpleMenu(List<Member> memberList) {
    System.out.println("- " + texts.getString("title") + " -\n");
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      String outputString = String.format("%d - %s, (email: %s, credits: %d, Items: %d)", i,
          member.getName(), member.getEmail(), member.getCredits(), member.getNumberOfItems());

      System.out.println(outputString);
    }
    System.out.println();
    System.out.println("a - " + texts.getString("addMember"));
    System.out.println("x - " + texts.getString("exit"));
  }

  private void displayDetailedMenu(List<Member> memberList) {
    System.out.println("- " + texts.getString("detailTitle") + " -\n");
    for (Member member : memberList) {
      System.out.println("Name: " + member.getName() + ", Email: " + member.getEmail());
      for (Item item : member.getItems()) {
        System.out.println("  Item: " + item.getName() + ", Description: " + item.getDescription());
        Contract contract = item.getCurrentContract();
        if (contract != null) {
          System.out.println("    Lent to: " + contract.getBorrower().getName()
              + ", Period: Day " + contract.getStartDay() + " to Day " + contract.getEndDay());
        }
      }
      System.out.println("---");
    }
  }
}
