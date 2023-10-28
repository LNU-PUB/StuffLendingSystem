package model;

public class Item {
  private ItemCategories category;
  private String name;
  private String description;
  private int creationDay;
  private int dailyLendingCost;

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
