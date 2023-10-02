package model;

import java.util.ArrayList;
import java.util.Random;
import model.lib.DataHandlingStrategy;
import model.lib.Email;
import model.lib.Id;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;

/**
 * Responsible for performing operations on members.
 */
public class MemberAdministration {
  private ArrayList<Member> members;

  public MemberAdministration(DataHandlingStrategy strategy) {
    DataHandling handler = new DataHandling(strategy);
    this.members = (ArrayList<Member>) handler.loadMembers();
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
   * @param time - The time of the member's creation.
   */
  public void addMember(Name name, Email email, Telephone telephone, Time time) {
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
    Member member = new Member(name, email, telephone, id, time);
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
    // For testing
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
    
    for (int i = 0; i < 6; i++) {
      tmp += alphaNum.charAt(random.nextInt(alphaNum.length()));
    }

    id = new Id(tmp);
    return id;
  }

}