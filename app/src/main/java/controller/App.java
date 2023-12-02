package controller;

import model.StuffLendingSystem;
import view.MainView;
import view.View;

// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The application.
 */
public class App {


  protected MainView createMainView() {
    return new MainView();
  }

  protected StuffLendingSystem createStuffSystem() {
    return new StuffLendingSystem();
  }

  protected void run() {
    StuffLendingSystem stuffSystem = createStuffSystem();
    View view = createMainView();
    StuffControl ctrl = new StuffControl(stuffSystem, view);

    while (ctrl.run()) {}
  }
  
  private void exit() {
    System.out.println("\nApplication is closing ...");
    System.exit(0);
  }

  /**
   * The main method.
   *
   * @param args - The arguments.
   */
  public static void main(String[] args) {
    App app = new App();
    app.run();
    app.exit();
  }
}
