package controller;

import java.util.ArrayList;

import model.Member;
import model.MemberAdministration;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.MemberMenu;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;
import view.ConsoleUi;

/**
 * Responsible for performing operations on members.
 */
public class ClubAdministration {
  private MemberAdministration memberAdmin;
  private ConsoleUi consoleUi;
  private Time time;

  /**
   * Constructor.
   *
   * @param strategy - The strategy to use for data handling.
   */
  public ClubAdministration(DataHandlingStrategy strategy) {
    memberAdmin = new MemberAdministration(strategy);
    consoleUi = new ConsoleUi();
    this.time = new Time();
  }

  /**
   * Starts the club.
   */
  public void startClub() {
    boolean exit = false;
    MemberMenu memberMenu;

    this.loadTestMembers();

    this.displayMembers();

    do {

      // new String[] {"1. Add member", "2. Delete member", "3. Display members", "4.
      // Increment day", "5. Exit"});

      String[] menuEntries = createMenuEntriesFromEnum(MemberMenu.values());
      String choice = consoleUi.getUserInput(menuEntries);

      switch (choice) {
        case memberMenu.ge.ADDMEMBER :
          String name = consoleUi.getString("Enter name: ");
          String email = consoleUi.getString("Enter email: ");
          String telephone = consoleUi.getString("Enter telephone: ");
          this.addMember(new Name(name), new Email(email), new Telephone(telephone), time);
          break;
        case 2:
          this.displayMembers();
          int id = consoleUi.getInt("Enter id: ");
          this.deleteMember(memberAdmin.getMember(id));
          break;
        case 3:
          this.displayMembers();
          break;
        case 4:
          this.incrementDay();
          break;
        case 5:
          exit = true;
          break;
        default:
          consoleUi.displayData("Invalid choice.");
      }
    } while (!exit);
  }

  private void loadTestMembers() {
  }

  /**
   * Adds a member to the system.
   *
   * @param name      - The name of the member.
   * @param email     - The email of the member.
   * @param telephone - The telephone of the member.
   * @param time      - The time of the member's creation.
   */
  public void addMember(Name name, Email email, Telephone telephone, Time time) {
    memberAdmin.addMember(name, email, telephone, time);

  }

  private <T extends Enum<T>> String[] createMenuEntriesFromEnum(T[] enumValues) {
    String[] options = new String[enumValues.length];
    for (int i = 0; i < enumValues.length; i++) {
      options[i] = enumValues[i].toString();
    }
    return options;
  }

  /**
   * Displays all the members in the system.
   */
  public void displayMembers() {
    consoleUi.displayData(memberAdmin.toString());
  }

  public void deleteMember(Member member) {
    memberAdmin.deleteMember(member);
  }

  /**
   * Returns an iterable of all the members in the system.
   *
   * @return - An iterable of all the members in the system.
   */
  public Iterable<Member> getMembers() {
    return memberAdmin.listMembers();
  }

  public void incrementDay() {
    time.incrementDay();
  }

  public boolean exit() {
    return this.memberAdmin.exit();
  }
}