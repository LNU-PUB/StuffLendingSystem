package com.model;

/**
 * Item class.
 * Represents an item that can be rented.
 */
public class Item {
  private final Member owner;
  private final String name;
  private final String category;
  private final String description;
  private final double costPerDay;
  private final int creationDay;
  private final Contract currentContract;

  /**
   * Constructor.
   *
   * @param owner - The owner of the item.
   * @param name  - The name of the item.
   * @param category - The category of the item.
   * @param description - The description of the item.
   * @param costPerDay - The cost per day of the item.
   * @param creationDay - The day the item was created.
   * @param currentContract - The current contract of the item or null if there is none.
   */
  public Item(Member owner, String name, String category, String description,
      double costPerDay, int creationDay, Contract currentContract) {
    this.owner = owner;
    this.name = name;
    this.category = category;
    this.description = description;
    this.costPerDay = costPerDay;
    this.creationDay = creationDay;
    this.currentContract = currentContract;
  }

  /**
   * Constructor.
   *
   * @param item - The item to copy.
   */
  public Item(Item item) {
    this.owner = item.getOwner();
    this.name = item.getName();
    this.category = item.getCategory();
    this.description = item.getDescription();
    this.costPerDay = item.getCostPerDay();
    this.creationDay = item.getCreationDay();
    this.currentContract = item.getCurrentContract();
  }

  public Member getOwner() {
    return this.owner;
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

  /**
   * Gets the current contract.
   *
   * @return - The current contract.
   */
  public Contract getCurrentContract() {
    return this.currentContract;
  }
}
