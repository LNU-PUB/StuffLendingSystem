package com.model;

import com.model.lib.Identifiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a member.
 */
public final class Member implements Identifiable {
  private final String id;
  private final String name;
  private final String email;
  private final String mobile;
  private final int memberCreationDay;

  /**
   * Constructor.
   *
   * @param id          - unique id.
   * @param name        - name of the member.
   * @param email       - email of the member.
   * @param mobile      - mobile number of the member.
   * @param creationDay - day the member was created.
   */
  public Member(String id, String name, String email, String mobile, int creationDay) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.memberCreationDay = creationDay;
  }

  @Override
  public String getId() {
    return id;
  }

  public int getMemberCreationDay() {
    return memberCreationDay;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getMobile() {
    return this.mobile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Member member = (Member) o;

    return Objects.equals(id, member.id)
        && Objects.equals(name, member.name)
        && Objects.equals(email, member.email)
        && Objects.equals(mobile, member.mobile)
        && memberCreationDay == member.memberCreationDay;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, mobile, memberCreationDay);
  }
}
