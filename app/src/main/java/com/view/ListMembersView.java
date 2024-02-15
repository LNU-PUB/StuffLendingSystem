package com.view;

import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import com.view.model.AbstractView;
import java.util.ArrayList;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  private final boolean detailedList;
  private final Language language;

  /**
   * Creates a new instance of the view.
   *
   * @param language     - the language to use.
   * @param bundleName   - the bundle name to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMembersView(Language language, String bundleName, boolean detailedList) {
    super(language, bundleName);
    this.language = language;
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu(Services service) {
    cleanScreen();
    displayGreeting();
    Iterable<Member> memberList;

    if (language == Language.ENG) {
      memberList = service.getMembersSortedBy(true, true);
    } else {
      memberList = service.getMembersSortedBy(false, true);
    }

    if (detailedList) {
      displayDetailedMenu(memberList, service);
    } else {
      displaySimpleMenu(memberList, service);
    }
  }

  private void displaySimpleMenu(Iterable<Member> memberList, Services service) {
    // List Name, Email, Credits, Number of Items
    System.out.println("- " + texts.getString("title") + " -\n");
    System.out.println("Members: " + getSizeOfList(memberList));
    int index = 0;
    for (Member member : memberList) {
      String outputString = String.format("%d - %s, (Email: %s, Credits: %.2f, Items: %d)", index,
          member.getName(), member.getEmail(), service.getMemberBalance(member),
          getSizeOfList(service.getItemsByMember(member)));
      // String outputString = String.format("%d - %s, (email: %s)", index,
      // member.getName(), member.getEmail());

      System.out.println(outputString);
      index++;
    }

    System.out.println();
    System.out.println("a - " + texts.getString("addMember"));
    System.out.println("x - " + texts.getString("exit"));
  }

  private void displayDetailedMenu(Iterable<Member> memberList, Services service) {
    System.out.println("- " + texts.getString("detailTitle") + " -\n");
    for (Member member : memberList) {
      System.out.println("Member:");
      String outputString = String.format("Name: %s, %nEmail: %s, %nMobile: %s, %nMember since: %d",
          member.getName(), member.getEmail(), member.getMobile(), member.getMemberCreationDay());
      System.out.println(outputString);

      System.out.println("\nItems: " + getSizeOfList(service.getItemsByMember(member)));

      for (Item item : service.getItemsByMember(member)) {
        String itemString = String.format("  Item: %s, %n  Category: %s," 
            + "%n  Description: %s, %n  Rental cost per day: %.2f, %n  Creation day: %d %n  ---",
            item.getName(), item.getCategory().getDisplayName(), item.getDescription(), item.getCostPerDay(),
            item.getCreationDay());
        System.out.println(itemString);
      }
      System.out.println("\n-----");
    }
  }
}
