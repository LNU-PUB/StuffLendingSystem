package model;

import model.lib.CategoryType;
import model.lib.ItemDescription;
import model.lib.Name;
import model.lib.Time;

/**
 * The item class.
 */
public class Item {
  private final Name name;
  private final ItemDescription description;
  private final CategoryType category;
  private final int creationDay;
  private final int rentCostDaily;

  /**
   * Item constructor.
   *
   * @param name          - The name of the item.
   * @param description   - The description of the item.
   * @param category      - The category of the item.
   * @param creationDay   - The day the item was created as Time.
   * @param rentCostDaily - The cost to rent the item daily.
   */
  public Item(Name name, ItemDescription description, CategoryType category, Time creationDay, int rentCostDaily) {
    this.name = new Name(name.getName());
    this.description = new ItemDescription(description.getItemDescription());
    this.category = category;
    this.creationDay = creationDay.getDay();
    this.rentCostDaily = rentCostDaily;
  }

  /**
   * Item constructor.
   *
   * @param name          - The name of the item.
   * @param description   - The description of the item.
   * @param category      - The category of the item.
   * @param creationDay   - The day the item was created as integer.
   * @param rentCostDaily - The cost to rent the item daily.
   */
  public Item(Name name, ItemDescription description, CategoryType category, int creationDay, int rentCostDaily) {
    this.name = new Name(name.getName());
    this.description = new ItemDescription(description.getItemDescription());
    this.category = category;
    this.creationDay = creationDay;
    this.rentCostDaily = rentCostDaily;
  }

  public String getName() {
    return name.getName();
  }

  public String getDescription() {
    return description.getItemDescription();
  }

  public CategoryType getCategory() {
    return category;
  }

  public int getCreationDay() {
    return creationDay;
  }

  public int getRentCostDaily() {
    return rentCostDaily;
  }

  public String getCategoryToString() {
    return category.getDisplayName();
  }

  @Override
  public String toString() {
    return "Name: "
        + this.name.getName()
        + "\nDescription: "
        + this.description.getItemDescription()
        + "\nCategory: " + this.category.getDisplayName()
        + "\nCreation Day: " + this.creationDay
        + "\nRent Cost Daily: " + this.rentCostDaily;
  }
}
