package model.lib;

/**
 * Represents a category type.
 * Types are: Tool, Vehicle, Game, Toy, Sport, Other.
 */
public enum CategoryType {
  TOOL("Tool"),
  VEHICLE("Vehicle"),
  GAME("Game"),
  TOY("Toy"),
  SPORT("Sport"),
  OTHER("Other");

  private final String displayName;

  CategoryType(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
