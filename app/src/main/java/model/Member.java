package model;

/**
 * Responsible for performing operations on members.
 */
public class Member {
  private Name name;
  private Email email;
  private Telephone telephone;
  private Id id;
  private int creationDay;
  private Time time;

  /**
   * The name class.
   */
  public static class Name {
    private String name;

    public Name(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  /**
   * The email class.
   * The email needs to be unique for each member.
   */
  public static class Email {
    private String email;

    public Email(String email) {
      this.email = email;
    }

    public String getEmail() {
      return email;
    }
  }

  /**
   * The telephone class.
   * The telephone number needs to be unique for each member.
   */
  public static class Telephone {
    private String telephone;

    public Telephone(String telephone) {
      this.telephone = telephone;
    }

    public String getTelephone() {
      return telephone;
    }
  }

  /**
   * The id class.
   */
  public static class Id {
    private String id;

    public Id(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  } 

  /**
   * Constructor for the member class.
   *
   * @param name - The name of the member.
   * @param email - The email of the member.
   * @param telephone - The telephone number of the member.
   * @param id - The id of the member.
   */
  public Member(Name name, Email email, Telephone telephone, Id id) {
    this.time = Time.getInstance();
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
  // Simple way of displaying the member.
  public String toString() {
    return "Member{"
        + "name=" + name.getName()
        + ", email=" + email.getEmail()
        + ", telephone=" + telephone.getTelephone()
        + ", id=" + id.getId()
        + ", creationDay=" + Integer.toString(creationDay) 
        + '}';
  }

  // Verbose way of displaying the member.

}
