package model;

/**
 * Item class represents a Members item.
 */
public class Item {
  private ItemCategories category;
  private String name;
  private String description;
  private int creationDay;
  private int dailyLendingCost;

  /**
   * Item Constructor.
   *
   * @param category - ItemCategories enum
   * @param name - name of item
   * @param description - description of item
   * @param creationDay - day item was created
   * @param dailyLendingCost - daily lending cost of item
   */
  public Item(ItemCategories category, String name, String description, int creationDay, int dailyLendingCost) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.creationDay = creationDay;
    this.dailyLendingCost = dailyLendingCost;
  }

  public ItemCategories getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getCreationDay() {
    return creationDay;
  }

  public int getDailyLendingCost() {
    return dailyLendingCost;
  }
}
