package controller;

// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The application.
 */
public class App {


  /**
   * Runs the application.
   */
  public void run() {}
  
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
  }
}
