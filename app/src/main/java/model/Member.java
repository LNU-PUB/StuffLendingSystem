package model;

import model.lib.Email;
import model.lib.Id;
import model.lib.Name;
import model.lib.Purse;
import model.lib.Telephone;
import model.lib.Time;

/**
 * Responsible for performing operations on members.
 */
public class Member {
  private final Name name;
  private final Email email;
  private final Telephone telephone;
  private final Id id;
  private final int creationDay;
  private final Purse purse;

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
    this.purse = new Purse();
  }

  /**
   * Constructor for the member class.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   * @param id - The id of the member.
   * @param creationDay - The day of the member's creation.
   */
  public Member(Name name, Email email, Telephone telephone, Id id, int creationDay) {
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.id = id;
    this.creationDay = creationDay;
    this.purse = new Purse();
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

  public int getCreationDay() {
    return creationDay;
  }

  public int getBalance() {
    return purse.getBalance();
  }

  public void addCredits(int amount) {
    purse.credit(amount);
  }

  public void subtractCredits(int amount) {
    purse.debit(amount);
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
