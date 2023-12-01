package controller.model;

/**
 * Represents the actions that can be performed on a member.
 */
public enum MemberActions {
  VIEWMEMBER("View Member"),
  ADDMEMBER("Add Member"),
  EDITMEMBER("Edit Member"),
  DELETEMEMBER("Delete Member"),
  SIMPLELISTMEMBERS("Members Simple List"),
  DETAILEDLISTMEMBERS("Members Detailed List");

  private final String name;

  MemberActions(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
