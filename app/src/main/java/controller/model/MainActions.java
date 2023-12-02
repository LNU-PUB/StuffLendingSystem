package controller.model;

/**
 * Represents the main actions of the application.
 */
public enum MainActions implements Actions {
  MEMBER("Member", 'm'),
  NEWCONTRACT("New Contract", 'n'),
  ADVANCETIME("Advance Time", 'a'),
  UNKNOWN("Unknown", 'u'),
  QUIT("Quit Application", 'q');

  private final String name;
  private final char selector;

  MainActions(String name, char selector) {
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
