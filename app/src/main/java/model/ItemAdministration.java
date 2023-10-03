package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for performing operations on items.
 */
public class ItemAdministration {
  private final List<Item> items;

  /**
   * Constructor for the item administration class.
   *
   * @param items - The list of items.
   */
  public ItemAdministration(List<Item> items) {
    this.items = new ArrayList<Item>(items);
  }

  public ItemAdministration() {
    this.items = new ArrayList<Item>();
  }

  /**
   * Adds an item to the item list.
   *
   * @param item - The item to be added.
   */
  public void addItem(Item item) {
    items.add(item);
  }

  /**
   * Removes an item from the item list.
   *
   * @param item - The item to be removed.
   */
  public void removeItem(Item item) {
    items.remove(item);
  }

  /**
   * Returns the item list.
   *
   * @return - The item list.
   */
  public List<Item> getItems() {
    return new ArrayList<Item>(items);
  }

  @Override
  public String toString() {
    StringBuffer buf = new StringBuffer();
    for (Item item : items) {
      buf.append("\n" + item.toString() + "\n");
    }
    return buf.toString();
  }
}
