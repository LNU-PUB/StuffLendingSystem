package model.lib;

import java.util.List;
import model.Member;

/**
 * Responsible for performing operations on members.
 */ 
public interface DataHandlingStrategy {
  
  public List<Member> loadMembers();

  public boolean persistMembers(List<Member> members);

  // Return true when done
  public boolean persistMembersBeforeExit(List<Member> members);
}
