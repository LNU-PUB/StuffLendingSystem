package model.lib;

public enum MemberMenu {
  VIEWMEMBER("View Member Details"),
  ADDMEMBER("Add Member"),
  LISTALLMEMBERS("List All Members"),
  EXIT("Exit");

  private final String description;

  MemberMenu(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
