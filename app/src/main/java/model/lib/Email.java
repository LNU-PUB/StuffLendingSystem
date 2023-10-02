package model.lib;

/**
 * Represents an email.
 */
public class Email {
  private String email;

  /**
   * Constructor.
   *
   * @param email - The email address.
   */
  public Email(String email) {
    this.email = email;
  }

  /**
   * Gets the email address.
   *
   * @return - The email address.
   */
  public String getEmail() {
    return email;
  }
}
