package controller;

import model.lib.HardCodeDataHandler;

/**
 * Responsible for staring the application.
 */
public class App {

  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {

    ClubAdministration clubAdministration = new ClubAdministration(new HardCodeDataHandler());
    clubAdministration.startClub();

    // Add a shutdown hook
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // clubAdministration.exit();

      // Wait for the exit operation to complete
      if (!waitForExitCompletion(clubAdministration)) {
        System.out.println("Exit operation took too long to complete.");
      } else {
        System.out.println("Exit operation completed successfully.");
      }
    }));
  }

  private static boolean waitForExitCompletion(ClubAdministration clubAdministration) {

    while (!clubAdministration.exit()) {
      try {
        Thread.sleep(500); // Adjust the polling interval as needed
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    // Return true if exit completed successfully
    return true;
  }
}
