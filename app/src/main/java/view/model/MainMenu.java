package view.model;

/**
 * Represents the main menu options.
 *
 * @since 1.0.0
 */
public enum MainMenu implements MenuOption {
  MEMBER_MENU("Member Menu"),
  ADVANCE_DAYS("Advance Days");

  private final String description;

  MainMenu(String description) {
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
    return "Main Menu";
  }
}
