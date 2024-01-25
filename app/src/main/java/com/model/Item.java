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
  private Contract currentContract;

  /**
   * Constructor.
   *
   * @param name        - name
   * @param category    - category
   * @param description - description
   * @param costPerDay  - rental cost per day
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

  public void setCurrentContract(Contract contract) {
    this.currentContract = contract;
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
    // Only for development remove the following content when done.
    // *** START ***
    // Item item1 = new Item("Hammer", "Tools", "A hammer", 1.0, 1);
    // Item item2 = new Item("Screwdriver", "Tools", "A screwdriver", 1.0, 1);
    // Item item3 = new Item("Drill", "Tools", "A drill", 1.0, 1);
    // Item item4 = new Item("Saw", "Tools", "A saw", 1.0, 1);
    // List<Item> list1 = new ArrayList<>();
    // list1.add(item1);
    // list1.add(item2);
    // List<Item> list2 = new ArrayList<>();
    // list2.add(item3);
    // list2.add(item4);
    // Member owner = new Member("123abc", "John Doe", "jon@doe.sss", "12345678",
    // list1);
    // Member borrower = new Member("456def", "Jane Doe", "jane@doe.sss",
    // "87654321", list2);
    // // Item item = new Item("Hammer", "Tools", "A hammer", 1.0, 1);
    // int startDay = 1;
    // int endDay = 2;
    // return new Contract(owner, item1, borrower, startDay, endDay);

    // *** END ***
    // TODO: Implement this method.
    return this.currentContract;
  }
}
