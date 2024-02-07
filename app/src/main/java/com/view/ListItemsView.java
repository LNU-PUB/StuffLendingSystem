package com.view;

import com.controller.model.DisplayDataBundles;
import com.controller.model.Language;
import com.model.Item;
import com.model.Member;
import com.view.model.AbstractView;
import java.util.Collection;

/**
 * A view for listing items.
 */
public class ListItemsView extends AbstractView {
  private boolean listAllItems;

  public ListItemsView(Language language, String bundleName, boolean listAllItems, Member member) {
    super(language, bundleName);
    this.listAllItems = listAllItems;
  }

  @Override
  public void displayMenu(DisplayDataBundles bundle) {
    cleanScreen();
    displayGreeting();

    display(bundle.getItems());
  }

  private void display(Iterable<Item> itemList) {
    System.out.println("- " + texts.getString("title") + " -\n");
    System.out.println("Items: " + getSizeOfTheList(itemList));
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
    System.out.println("a - " + texts.getString("addItem"));
    System.out.println("x - " + texts.getString("exit"));
  }

  private int getSizeOfTheList(Iterable<Item> items) {
    if (items instanceof Collection<?>) {
      return ((Collection<?>) items).size();
    } else {
      int size = 0;
      for (Item item : items) {
        size++;
      }
      return size;
    }
  }
}
