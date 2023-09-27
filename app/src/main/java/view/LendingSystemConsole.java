package view;

import java.lang.reflect.Member;

/**
 * Responsible for displaying information to the user.
 */
public class LendingSystemConsole {
  
  public void displayMember(Member member) {
    System.out.println(member.toString());
  }

}
