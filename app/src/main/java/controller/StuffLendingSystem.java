package controller;

import model.Member.Email;
import model.Member.Name;
import model.Member.Telephone;
import model.Time;

/**
 * Responsible for staring the application.
 */
public class StuffLendingSystem {
  static Time time;

  /**
   * Application starting point.
   *
   * @param args command line arguments.
   *
   */
  
  public static void main(String[] args) {
    SystemAdministrator systemAdministrator = new SystemAdministrator();
    time = Time.getInstance();
    systemAdministrator.addMember(new Name("John Doe"), new Email("john@email.com"),
        new Telephone("1234567890"));

    time.incrementDay();
    systemAdministrator.addMember(new Name("Jane Doe"), new Email("jane@email.com"),
        new Telephone("1234567899"));
    time.incrementDay();
    systemAdministrator.addMember(new Name("Chris"), new Email("chris@email.com"),
        new Telephone("1234567111"));


    systemAdministrator.getMembers();
  }
}
