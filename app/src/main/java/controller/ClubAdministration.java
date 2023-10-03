package controller;

import model.Member;
import model.MemberAdministration;
import model.lib.DataHandlingStrategy;
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
  public ClubAdministration(DataHandlingStrategy strategy) {
    memberAdmin = new MemberAdministration(strategy);
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

  public void incrementDay() {
    time.incrementDay();
  }
}