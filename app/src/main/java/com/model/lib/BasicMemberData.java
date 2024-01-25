package com.model.lib;

/**
 * Basic member data.
 */
public class BasicMemberData {
  private final String name;
  private final String email;
  private final String mobile;

  /**
   * Constructor.
   *
   * @param name   - name
   * @param email  - email
   * @param mobile - mobile
   */
  public BasicMemberData(String name, String email, String mobile) {
    this.name = name;
    this.email = email;
    this.mobile = mobile;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getMobile() {
    return mobile;
  }
}
