package com.view.model;

import com.controller.model.Language;
import com.model.Contract;
import com.model.Item;
import com.model.Member;
import com.model.Services;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Responsible for displaying information to the user.
 */
public class ListMembersView extends AbstractView {
  private final boolean detailedList;
  private final Language language;
  private final ResourceBundle memberTexts;

  /**
   * Creates a new instance of the view.
   *
   * @param language     - the language to use.
   * @param bundleName   - the bundle name to use.
   * @param detailedList - true if the list should be detailed, false if not.
   */
  public ListMembersView(Language language, String bundleName, boolean detailedList) {
    super(language, bundleName);
    Locale locale = new Builder().setLanguage(language.getLanguage()).setRegion(language.getCountry()).build();
    memberTexts = ResourceBundle.getBundle("com.view.BasicMemberData", locale);
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
    System.out.println(memberTexts.getString("members") + ": " + service.getSizeOfList(memberList));
    int index = 0;
    for (Member member : memberList) {
      String outputString = String.format("%d - %s, ("
          + memberTexts.getString("email") + ": %s, "
          + memberTexts.getString("credits") + ": %.2f, "
          + memberTexts.getString("items") + ": %d)", index,
          member.getName(), member.getEmail(), service.getMemberBalance(member),
          service.getSizeOfList(service.getItemsByMember(member)));

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
      System.out.println(memberTexts.getString("member") + ":");
      String outputString = String.format(memberTexts.getString("name") + ": %s, %n"
          + memberTexts.getString("email") + ": %s, %n"
          + memberTexts.getString("mobile") + ": %s, %n"
          + memberTexts.getString("member_since") + ": %d",
          member.getName(), member.getEmail(), member.getMobile(), member.getMemberCreationDay());
      System.out.println(outputString);

      System.out.println("\nItems: " + service.getSizeOfList(service.getItemsByMember(member)));

      for (Item item : service.getItemsByMember(member)) {
        String itemString = String.format("  Item: %s, %n  Category: %s,"
            + "%n  Description: %s, %n  Rental cost per day: %.2f, %n  Creation day: %d ",
            item.getName(), item.getCategory().getDisplayName(), item.getDescription(), item.getCostPerDay(),
            item.getCreationDay());
        System.out.println(itemString);
        System.out.print("\n    --\n    Current Contract: ");
        if (service.isItemAvailable(item, service.getDay(), service.getDay())) {
          System.out.println(memberTexts.getString("no_contracts"));
        } else {
          // List open contracts at the present time.
          for (Contract contract : service.getItemSpecificContractsForRange(item, service.getDay(), service.getDay())) {
            System.out.println("  " + contract.getBorrower().getName() + " has rented this item from day "
                + contract.getStartDay() + " to day " + contract.getEndDay());
          }
        }
        System.out.println("  ---\n");
      }
      System.out.println("\n-----");
    }
  }
}
