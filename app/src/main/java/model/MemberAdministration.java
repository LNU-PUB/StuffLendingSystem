package model;

import java.util.ArrayList;
import java.util.Random;
import model.Member.Email;
import model.Member.Id;
import model.Member.Name;
import model.Member.Telephone;

/**
 * Responsible for performing operations on members.
 */
public class MemberAdministration {
  private ArrayList<Member> members;

  public MemberAdministration() {
    members = new ArrayList<Member>();
  }

  public void deleteMember(Member member) {
    members.remove(member);
  }

  /**
   * Adds a member to the member list.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   */
  public void addMember(Name name, Email email, Telephone telephone) {
    if (checkEmail(email.getEmail())) {
      System.out.println("Email already in use.");
      return;
    }
    if (checkTelephone(telephone.getTelephone())) {
      System.out.println("Telephone already in use.");
      return;
    }
    Id id = generateNewMemberId();
    if (checkId(id.getId())) {
      System.out.println("Id already in use.");
      return;
    }
    Member member = new Member(name, email, telephone, id);
    members.add(member);
  }

  // Checks if the email is unique.
  private boolean checkEmail(String email) {
    for (Member member : members) {
      if (member.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }

  // Checks if the telephone is unique.
  private boolean checkTelephone(String telephone) {
    for (Member member : members) {
      if (member.getTelephone().equals(telephone)) {
        return true;
      }
    }
    return false;
  }

  // Checks if the id is unique.
  private boolean checkId(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Lists all the members.
   *
   * @return - An iterable of all the members.
   */
  public Iterable<Member> listMembers() {
    return members;
    // System.out.println("Members:");
    // for (Member member : members) {
    // System.out.println(member.toString());
    // }
  }

  private Id generateNewMemberId() {
    String alphaNum = "1234567890abcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    String tmp = "";
    Id id = null;
    // int count = 0;
    // do {
    // the id should be 6 chars long, with random chars from the alphaNum string
    for (int i = 0; i < 6; i++) {
      tmp += alphaNum.charAt(random.nextInt(alphaNum.length()));
    }
    // tmp="123asd";
    id = new Id(tmp);
    // count++;
    // } while (checkId(id.getId()) && count < 10); // check if the id is already in
    // use
    return id;
  }

}