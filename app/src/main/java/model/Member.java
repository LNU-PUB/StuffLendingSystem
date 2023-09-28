package model;

import model.lib.Email;
import model.lib.Id;
import model.lib.Name;
import model.lib.Telephone;
import model.lib.Time;

/**
 * Responsible for performing operations on members.
 */
public class Member {
  private Name name;
  private Email email;
  private Telephone telephone;
  private Id id;
  private int creationDay;

  /**
   * Constructor for the member class.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   * @param id - The id of the member.
   * @param time - The time of the member's creation.
   */
  public Member(Name name, Email email, Telephone telephone, Id id, Time time) {
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.id = id;
    this.creationDay = time.getDay();
  }

  public String getName() {
    return name.getName();
  }

  public String getEmail() {
    return email.getEmail();
  }

  public String getTelephone() {
    return telephone.getTelephone();
  }

  public String getId() {
    return id.getId();
  }

  @Override
  public String toString() {
    return "Member{"
        + "name=" + name.getName()
        + ", email=" + email.getEmail()
        + ", telephone=" + telephone.getTelephone()
        + ", id=" + id.getId()
        + ", creationDay=" + Integer.toString(creationDay) 
        + '}';
  }
}
