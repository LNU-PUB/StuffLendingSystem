package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The stuff lending system.
 */
public class StuffLendingSystem {
  /**
   * The time.
   */
  protected class Time {
    private int time;

    private Time() {
      this.time = 0;
    }

    private void advanceTime() {
      this.time++;
    }

    public int getTime() {
      return this.time;
    }
  }

  private Time time;
  private DataHandlerMember dataHandler;
  private List<Member> members;

  /**
   * Creates a new instance of the stuff lending system.
   */
  public StuffLendingSystem() {
    this.time = new Time();
    this.dataHandler = new DataHardCodedMember();
    this.members = dataHandler.getMembers();
  }

  /**
   * Gets the time.
   *
   * @return - The time.
   */
  public int getTime() {
    return this.time.getTime();
  }

  /**
   * Advances the time.
   */
  public void advanceTime() {
    this.time.advanceTime();
  }

  /**
   * Gets the member list.
   *
   * @return - The member list.
   */
  public List<Member> getMemberList() {
    return (List<Member>) new ArrayList<>(members);
  }

  /**
   * Updates the member list.
   *
   * @param member - The member to update.
   */
  public void updateMemberList(Member member) {
  }
}
