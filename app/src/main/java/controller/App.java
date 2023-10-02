package controller;

import model.dataHandlers.HardCodeDataHandler;

/**
 * Responsible for staring the application.
 */
public class App {

  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {

    ClubAdministration clubAdministration = new ClubAdministration(new HardCodeDataHandler());
    clubAdministration.startClub();
  }
}
