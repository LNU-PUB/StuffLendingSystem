package model.lib;

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
   * Gets the item description.
   *
   * @return - The item description.
   */
  public String getItemDescription() {
    return itemDescription;
  }
}
