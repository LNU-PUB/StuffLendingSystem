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
  private boolean detailedList;

  public ListItemsView(Language language, String bundleName, boolean detailedList, Member member) {
    super(language, bundleName);
    this.detailedList = detailedList;
  }

  @Override
  public void displayMenu(DisplayDataBundles bundle) {
    cleanScreen();
    displayGreeting();

    if (detailedList || !detailedList) {
      display(bundle.getItems());
    }
  }

  private void display(Iterable<Item> itemList) {
    System.out.println("- " + texts.getString("title") + " -\n");
    System.out.println("Items: " + getSizeOfTheList(itemList));
    int index = 0;
    for (Item item : itemList) {
      String outputString = String.format("%d. %s %s", index, item.getName(), item.getCategory());

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
