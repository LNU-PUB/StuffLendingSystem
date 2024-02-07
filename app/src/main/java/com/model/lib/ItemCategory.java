package com.model.lib;

/**
 * The item category enum.
 */
public enum ItemCategory {
  TOOL("tool", "Tools"),
  VEHICLE("vehicle", "Vehicle"),
  GAME("game", "Games"),
  TOY("toy", "Toys"),
  SPORT("sport", "Sports"),
  OTHER("other", "Other");

  private final String category;
  private final String displayName;

  ItemCategory(String category, String displayName) {
    this.category = category;
    this.displayName = displayName;
  }

  public String getCategory() {
    return category;
  }

  public String getDisplayName() {
    return displayName;
  }
}
