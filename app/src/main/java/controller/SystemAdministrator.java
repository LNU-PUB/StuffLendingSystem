package controller;

import model.Member;
import model.Member.Email;
import model.Member.Name;
import model.Member.Telephone;
import model.MemberAdministration;





/**
 * Responsible for performing operations on members.
 */
public class SystemAdministrator {
  private MemberAdministration memberAdmin;

  public SystemAdministrator() {
    memberAdmin = new MemberAdministration();
  }

  /**
   * Adds a member to the system.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone of the member.
   */
  public void addMember(Name name, Email email, Telephone telephone) {
    memberAdmin.addMember(name, email, telephone);
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