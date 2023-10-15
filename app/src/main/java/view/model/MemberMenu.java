package view.model;

/**
 * Represents the member menu options.
 *
 * @since 1.0.0
 */
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

  /**
   * Gets the description of the menu option.
   *
   * @return - The description of the menu option.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the name of the menu.
   *
   * @return - The name of the menu.
   */
  @Override
  public String getMenuName() {
    return "Member Menu";
  }
}
