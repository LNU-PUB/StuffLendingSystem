package controller;

import model.Member;
import model.lib.Email;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;
import model.MemberAdministration;
import view.ConsoleUi;





/**
 * Responsible for performing operations on members.
 */
public class SystemAdministrator {
  private MemberAdministration memberAdmin;
  private ConsoleUi consoleUI;

  public SystemAdministrator() {
    memberAdmin = new MemberAdministration();
    consoleUI = new ConsoleUi();
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
  // public void addMember() {
  //   System.out.println("Enter name: ");
  //   Name name = new Name(System.console().readLine());
  //   System.out.println("Enter email: ");
  //   Email email = new Email(System.console().readLine());
  //   System.out.println("Enter telephone: ");
  //   Telephone telephone = new Telephone(System.console().readLine());
  //   persistence.addMember(name, email, telephone);
  // }

  public void displayMembers() {
    for (Member member : memberAdmin.listMembers()) {
      consoleUI.displayData(member.toString());
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