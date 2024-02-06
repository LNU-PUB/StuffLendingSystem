package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.model.Member;
import com.view.model.AbstractView;
import java.util.Collection;

/**
 * A view for listing items.
 */
public class ListItemsView extends AbstractView {
  private boolean detailedList;

  public ListItemsView(Language language, String bundleName, boolean detailedList) {
    super(language, bundleName);
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu(DisplayDataBundles bundle) {
    cleanScreen();
    displayGreeting();
    // this.memberList = memberServ.getAllMembers();
    if (detailedList) {
      displayDetailedMenu(bundle.getMembers());
    } else {
      displaySimpleMenu(bundle.getMembers());
    }
  }

  private void displayDetailedMenu(Iterable<Member> members) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayDetailedMenu'");
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
  
  private int getSizeOfTheMembersList(Iterable<Member> members) {
    if (members instanceof Collection<?>) {
      return ((Collection<?>) members).size();
    } else {
      int size = 0;
      for (Member member : members) {
        size++;
      }
      return size;
    }
  }
}
