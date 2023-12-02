package view;

/**
 * Responsible for displaying information to the user.
 */
public interface View {
  public void displayMenu();

  public controller.model.Actions getInput();
}
