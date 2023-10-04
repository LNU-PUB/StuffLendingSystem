package model.menu;

public enum MemberMenu implements MenuOption {
  ADDMEMBER("Add Member"),
  DELETEMEMEBER("Delete Member"),
  UPDATEMEMBER("Update Member"),
  VIEWMEMBER("View Member Details"),
  LISTALLMEMBERSPARITAL("List All Members Partial Details"),
  LISTALLMEMBERS("List All Members Full Details");


  private final String description;

  MemberMenu(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
