package model;

import java.util.ArrayList;
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
  private final ItemAdministration itemAdmin;

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
    this.itemAdmin = new ItemAdministration();
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
    this.itemAdmin = new ItemAdministration();
  }

  /**
   * Constructor for the member class.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   * @param id - The id of the member.
   * @param creationDay - The day of the member's creation.
   * @param itemAdmin - The item administration.
   */
  public Member(Name name, Email email, Telephone telephone, Id id, int creationDay, ItemAdministration itemAdmin) {
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.id = id;
    this.creationDay = creationDay;
    this.purse = new Purse();
    this.itemAdmin = new ItemAdministration(new ArrayList<Item>(itemAdmin.getItems()));
  }

  /**
   * Constructor for the member class.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   * @param id - The id of the member.
   * @param time - The time of the member's creation.
   * @param itemAdmin - The item administration.
   */
  public Member(Name name, Email email, Telephone telephone, Id id, Time time, ItemAdministration itemAdmin) {
    this.name = name;
    this.email = email;
    this.telephone = telephone;
    this.id = id;
    this.creationDay = time.getDay();
    this.purse = new Purse();
    this.itemAdmin = new ItemAdministration(new ArrayList<Item>(itemAdmin.getItems()));
  }

  public void addItem(Item item) {
    this.itemAdmin.addItem(item);
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
    return "Member{\n"
        + "name=" + name.getName() + "\n"
        + "email=" + email.getEmail() + "\n"
        + "telephone=" + telephone.getTelephone() + "\n"
        + "id=" + id.getId() + "\n"
        + "creationDay=" + Integer.toString(creationDay) + "\n"
        + "purse=" + purse.getBalance() + "\n"
        + "\n* items: *" + itemAdmin.toString()
        + "\n}";
  }
}
