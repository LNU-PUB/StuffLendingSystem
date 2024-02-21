package com.view.model;

import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.model.Services;

/**
 * A view for listing items.
 */
public class ListItemsView extends AbstractView {
  private boolean listAllItems;
  private Member member;

  /**
   * Creates a new instance of the view.
   *
   * @param language     - the language to use.
   * @param bundleName   - the bundle name to use.
   * @param listAllItems - true if all items should be listed, false if not.
   * @param member       - the member to list items for.
   */
  public ListItemsView(Language language, String bundleName, boolean listAllItems, Member member) {
    super(language, bundleName);
    this.listAllItems = listAllItems;
    this.member = member;
  }

  @Override
  public void displayMenu(Services service) {
    cleanScreen();
    displayGreeting();

    if (listAllItems) {
      display(service, service.getAllItems());
    } else {
      display(service, service.getItemsByMember(this.member));
    }
  }

  private void display(Services service, Iterable<Item> itemList) {
    System.out.println("- " + texts.getString("title") + " -\n");
    System.out.println("Items: " + service.getSizeOfList(itemList));
    int index = 0;
    for (Item item : itemList) {
      String outputString = listAllItems
          ? String.format("%d. %s %s %s", index, item.getName(), item.getOwner().getName(),
              item.getCategory().getDisplayName())
          : String.format("%d. %s %s", index, item.getName(), item.getCategory().getDisplayName());

      System.out.println(outputString);
      index++;
    }

    System.out.println();
    if (member != null) {
      System.out.println("a - " + texts.getString("addItem"));
    }
    System.out.println("x - " + texts.getString("exit"));
  }
}
