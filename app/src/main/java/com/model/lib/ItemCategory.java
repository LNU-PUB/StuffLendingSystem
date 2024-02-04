package com.model.lib;

public enum ItemCategory {
  TOOL("tool"),
  VEHICLE("vehicle"),
  GAME("game"),
  TOY("toy"),
  SPORT("sport"),
  OTHER("other");

  private final String category;

  ItemCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }
}
