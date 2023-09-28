package controller;

import model.lib.Email;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;

/**
 * Responsible for staring the application.
 */
public class App {
  static Time time;

  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    SystemAdministrator systemAdministrator = new SystemAdministrator();
    time = new Time();
    systemAdministrator.addMember(new Name("John Doe"), new Email("john@email.com"),
        new Telephone("1234567890"), time);

    time.incrementDay();
    systemAdministrator.addMember(new Name("Jane Doe"), new Email("jane@email.com"),
        new Telephone("1234567899"), time);
    time.incrementDay();
    systemAdministrator.addMember(new Name("Chris"), new Email("chris@email.com"),
        new Telephone("1234567111"), time);

    systemAdministrator.displayMembers();
  }
}
