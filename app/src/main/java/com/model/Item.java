package com.model;

/**
 * Item class.
 * Represents an item that can be rented.
 */
public class Item {
  private String name;
  private String category;
  private String description;
  private double costPerDay;
  private int creationDay;

  /**
   * Constructor.
   *
   * @param name - name
   * @param category - category
   * @param description - description
   * @param costPerDay - rental cost per day
   * @param creationDay - creation day
   */
  public Item(String name, String category, String description, double costPerDay, int creationDay) {
    this.name = name;
    this.category = category;
    this.description = description;
    this.costPerDay = costPerDay;
    this.creationDay = creationDay;
  }

  /**
   * Constructor.
   *
   * @param item - The item to copy.
   */
  public Item(Item item) {
    this.name = item.getName();
    this.category = item.getCategory();
    this.description = item.getDescription();
    this.costPerDay = item.getCostPerDay();
    this.creationDay = item.getCreationDay();
  }

  public String getName() {
    return this.name;
  }

  public String getCategory() {
    return this.category;
  }

  public String getDescription() {
    return this.description;
  }

  public double getCostPerDay() {
    return this.costPerDay;
  }

  public int getCreationDay() {
    return this.creationDay;
  }
}
