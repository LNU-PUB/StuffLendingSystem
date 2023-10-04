package controller;

import model.Member;
import model.MemberAdministration;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;
import model.menu.MainMenu;
import model.menu.MenuOption;
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
    

    this.loadTestMembers();

    this.displayMembers();

    int counter = 0;
    do {
      exit = mainMenu();
    } while (!exit && counter < 5);
  }

  private boolean mainMenu() {
    MainMenu memberMenu;
    boolean exit = false;
    // new String[] {"1. Add member", "2. Delete member", "3. Display members", "4.
    // Increment day", "5. Exit"});

    String[] menuEntries = createMenuEntriesFromEnum(MainMenu.values());
    // String choice = consoleUi.getUserInput(menuEntries);
    consoleUi.menu("Main Menu", menuEntries);
    String choice = consoleUi.getString("\nEnter choice: ");

    // for testing only
    // System.out.println("selected choice: " + choice);
    // if (choice.equals("q") || choice.equals("Q") || choice.equals("0")) {
    // exit = true;
    // } else {
    // counter++;
    // }
    // System.out.println("counter: " + counter + "\nexit: " + exit);

    switch (choice) {
      case "1":
        String name = consoleUi.getString("Enter name: ");
        String email = consoleUi.getString("Enter email: ");
        String telephone = consoleUi.getString("Enter telephone: ");
        this.addMember(new Name(name), new Email(email), new Telephone(telephone),
            time);
        break;
      case "2":
        this.displayMembers();
        // int id = consoleUi.getInt("Enter id: ");
        // this.deleteMember(memberAdmin.getMember(id));
        break;
      case "3":
        this.displayMembers();
        break;
      case "4":
        this.incrementDay();
        break;
      case "Q":
      case "q":
      case "0":
        exit = true;
        break;
      default:
        consoleUi.displayData("Invalid choice.");
    }
    return exit;
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

  private String[] createMenuEntriesFromEnum(MenuOption[] enumValues) {
    String[] options = new String[enumValues.length + 1];
    for (int i = 0; i < enumValues.length; i++) {
      options[i] = (i + 1) + ". " + enumValues[i].getDescription();
    }
    options[enumValues.length] = "\nQ, q, or 0 to Exit or Return";
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