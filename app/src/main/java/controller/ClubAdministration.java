package controller;

import model.Member;
import model.MemberAdministration;
import model.lib.Email;
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
   */
  public ClubAdministration() {
    memberAdmin = new MemberAdministration();
    consoleUi = new ConsoleUi();
    this.time = new Time();
  }

  /**
   * Starts the club.
   */
  public void startClub() {
    
    this.loadTestMembers();

    this.displayMembers();
  }

  private void loadTestMembers() {
    this.addMember(new Name("John Doe"), new Email("john@email.com"),
        new Telephone("1234567890"), this.time);

    time.incrementDay();
    this.addMember(new Name("Jane Doe"), new Email("jane@email.com"),
        new Telephone("1234567899"), this.time);
    time.incrementDay();
    this.addMember(new Name("Chris"), new Email("chris@email.com"),
        new Telephone("1234567111"), this.time);
  }

  /**
   * Adds a member to the system.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone of the member.
   * @param time - The time of the member's creation.
   */
  public void addMember(Name name, Email email, Telephone telephone, Time time) {
    memberAdmin.addMember(name, email, telephone, time);

  }

  /**
   * Displays all the members in the system.
   */
  public void displayMembers() {
    for (Member member : memberAdmin.listMembers()) {
      consoleUi.displayData(member.toString());
    }
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
}