package controller.model;

/**
 * Represents the actions that can be performed on a member.
 */
public enum MemberActions implements Actions {
  VIEWMEMBER("View Member", 'v'),
  ADDMEMBER("Add Member", 'a'),
  EDITMEMBER("Edit Member", 'e'),
  DELETEMEMBER("Delete Member", 'd'),
  SIMPLELISTMEMBERS("Members Simple List", 's'),
  DETAILEDLISTMEMBERS("Members Detailed List", 'l'),
  UNKNOWN("Unknown", 'u'),
  EXIT("Exit Members", 'x');

  private final String name;
  private final char selector;

  MemberActions(String name, char selector) {
    this.name = name;
    this.selector = selector;
  }

  public String getName() {
    return name;
  }

  public char getSelector() {
    return selector;
  }
}
