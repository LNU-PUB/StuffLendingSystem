package model.lib;

/**
 * Represents an item description.
 */
public class ItemDescription {
  private final String itemDescription;

  /**
   * Constructor.
   *
   * @param itemDescription - The item description.
   */
  public ItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  /**
   * Constructor.
   */
  public ItemDescription() {
    this.itemDescription = "";
  }

  /**
   * Gets the item description.
   *
   * @return - The item description.
   */
  public String getItemDescription() {
    return itemDescription;
  }
}
