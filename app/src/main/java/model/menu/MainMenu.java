package model.menu;

public enum MainMenu implements MenuOption {
  VIEWMEMBER("View Member Details"),
  ADDMEMBER("Add Member"),
  LISTALLMEMBERS("List All Members");

  private final String description;

  MainMenu(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
