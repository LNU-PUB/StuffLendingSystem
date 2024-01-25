package com.model;

public class TimeService {
  private Time currentTime;

  public TimeService() {
    this.currentTime = new Time();
  }

  public int getDay() {
    return currentTime.getCurrentDay();
  }

  public void advanceDay(){
    this.currentTime = currentTime.advanceDay();
  }
}
