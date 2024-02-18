package com.model;

import com.model.lib.Identifiable;
import com.model.lib.ItemCategory;
import java.util.Objects;

/**
 * Item class.
 * Represents an item that can be rented.
 */
public final class Item implements Identifiable {
  private final String id;
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
   * @param owner           - The owner of the item.
   * @param name            - The name of the item.
   * @param category        - The category of the item.
   * @param description     - The description of the item.
   * @param costPerDay      - The cost per day of the item.
   * @param creationDay     - The day the item was created.
   * @param currentContract - The current contract of the item or null if there is
   *                        none.
   */
  public Item(String id, Member owner, String name, ItemCategory category, String description,
      double costPerDay, int creationDay, Contract currentContract) {
    this.id = id;
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
    this.id = item.getId();
    this.owner = item.getOwner();
    this.name = item.getName();
    this.category = item.getCategory();
    this.description = item.getDescription();
    this.costPerDay = item.getCostPerDay();
    this.creationDay = item.getCreationDay();
    this.currentContract = item.getCurrentContract();
  }

  public String getId() {
    return this.id;
  }

  public Member getOwner() {
    return new Member(owner.getId(), owner.getName(), owner.getEmail(),
        owner.getMobile(), owner.getMemberCreationDay());
  }

  public String getName() {
    return this.name;
  }

  public ItemCategory getCategory() {
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
    if (currentContract == null) {
      return null;
    }
    return new Contract(currentContract);
  }

  @Override
  public String toString() {
    return "Item{"
        + "id='" + getId() + '\''
        + ", owner=" + getOwner().getName()
        + ", name='" + getName() + '\''
        + ", category=" + getCategory().getDisplayName()
        + ", description='" + getDescription() + '\''
        + ", costPerDay=" + getCostPerDay()
        + ", creationDay=" + getCreationDay()
        // + ", currentContract=" + getCurrentContract() == null ? "No contract" : getCurrentContract().getId()
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Item item = (Item) o;

    return Objects.equals(id, item.id)
        && Objects.equals(owner, item.owner)
        && Objects.equals(name, item.name)
        && category == item.category
        && Objects.equals(description, item.description)
        && Double.compare(item.costPerDay, costPerDay) == 0
        && creationDay == item.creationDay
        && Objects.equals(currentContract, item.currentContract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, owner, name, category, description, costPerDay, creationDay,
        currentContract);
  }
}
