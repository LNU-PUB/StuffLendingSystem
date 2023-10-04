package model.menu;

public enum MainMenu implements MenuOption{
  MEMBER_MENU("Member Menu"),
  ADVANCE_DAYS("Advance Days");

  private final String description;

  MainMenu(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
