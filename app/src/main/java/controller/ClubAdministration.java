package controller;

import model.Member;
import model.MemberAdministration;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;
import model.menu.Command;
import model.menu.MainMenu;
import model.menu.MemberMenu;
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
    MainMenuCommandMapper mainMenuCommandMapper = new MainMenuCommandMapper();
    boolean exit = false;

    String[] menuEntries = createMenuEntriesFromEnum(MainMenu.values());
    consoleUi.menu("Main Menu", menuEntries);
    String choice = consoleUi.getString("\nEnter choice: ");

    if (checkNumericRange(choice, MainMenu.values().length)) {
      int choiceInt = Integer.parseInt(choice) - 1;
      mainMenuCommandMapper.getCommand(MainMenu.values()[choiceInt]).execute();
    } else {
      if (choice.equalsIgnoreCase("q") || choice.equals("0")) {
        exit = true;
      } else {
        consoleUi.displayData("Invalid choice.");
      }
    }

    // consoleUi.displayData("Invalid choice.");
    // return false;
    return exit;
  }

  private boolean checkNumericRange(String choice, int max) {
    if (choice != null && !choice.isEmpty()) {
      if (choice.matches("[1-9]\\d*")) {
        int c = Integer.parseInt(choice);
        return c < max + 1;
      }
    }
    return false;
  }

  private void executeCommand(Command command) {
    if (command != null) {
      command.execute();
    } else {
      consoleUi.displayData("Invalid choice.");
    }
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