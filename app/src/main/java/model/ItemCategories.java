package model;

public enum ItemCategories {
  TOOL("Tool"),
  VEHICLE("Vehicle"),
  GAME("Game"),
  TOY("Toy"),
  SPORT("Sport"),
  OTHER("Other");

  private String description;

  private ItemCategories(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
