package model;

import model.lib.CategoryType;
import model.lib.ItemDescription;
import model.lib.Name;
import model.lib.Time;

/**
 * The item class.
 */
public class Item {
  private final String name;
  private final String description;
  private final CategoryType category;
  private final int creationDay;
  private final int rentCostDaily;

  public Item(Name name, ItemDescription description, CategoryType category, Time creationDay, int rentCostDaily) {
    this.name = "";
    this.description = "";
    this.category = category;
    this.creationDay = creationDay.getDay();
    this.rentCostDaily = 0;
  }

  public Item(Name name, ItemDescription description, CategoryType category, int creationDay, int rentCostDaily) {
    this.name = "";
    this.description = "";
    this.category = category;
    this.creationDay = creationDay;
    this.rentCostDaily = 0;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
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
}
