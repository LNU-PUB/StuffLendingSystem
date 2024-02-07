package com.model.lib;

import com.model.Contract;
import com.model.Member;

/**
 * Basic item data.
 */
public class BasicItemData {
  private final Member owner;
  private final String name;
  private final ItemCategory category;
  private final String description;
  private final double costPerDay;
  private final int creationDay;
  private final Contract currentContract;

  /**
   * Constructor.
   *
   * @param owner - the owner
   * @param name - the name
   * @param category - the category
   * @param description - the description
   * @param costPerDay - the cost per day
   * @param creationDay - the creation day
   */
  public BasicItemData(Member owner, String name, ItemCategory category, String description,
      double costPerDay, int creationDay) {
    this.owner = owner;
    this.name = name;
    this.category = category;
    this.description = description;
    this.costPerDay = costPerDay;
    this.creationDay = creationDay;
    this.currentContract = null;
  }

  public Member getOwner() {
    return owner;
  }

  public String getName() {
    return name;
  }

  public ItemCategory getCategory() {
    return category;
  }

  public String getDescription() {
    return description;
  }

  public double getCostPerDay() {
    return costPerDay;
  }

  public int getCreationDay() {
    return creationDay;
  }

  public Contract getCurrentContract() {
    return currentContract;
  }
}
