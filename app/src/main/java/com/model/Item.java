package com.model;

public class Item {
  private String name;
    private String category;
    private String description;
    private double costPerDay;
    private int creationDay;

    public Item(String name, String category, String description, double costPerDay, int creationDay) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.costPerDay = costPerDay;
        this.creationDay = creationDay;
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
