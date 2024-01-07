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
  private List<Member> members;

  public StuffLendingSystem() {
    this.time = new Time();
    this.members = new ArrayList<>();
  }

  public int getTime() {
    return this.time.getTime();
  }

  public void advanceTime() {
    this.time.advanceTime();
  }

  public List<Member> getMemberList() {
    return new ArrayList<>(members);
  }

  public void updateMemberList(Member member) {
  }
}
