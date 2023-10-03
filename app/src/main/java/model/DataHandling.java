package model;

import java.util.List;
import model.lib.DataHandlingStrategy;

/**
 * Responsible for performing operations on members.
 */
public class DataHandling implements DataHandlingStrategy {
  private DataHandlingStrategy strategy;

  /**
   * Constructor.
   *
   * @param strategy - The strategy to use.
   */
  public DataHandling(DataHandlingStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Loads the members.
   *
   * @return - The members.
   */
  public List<Member> loadMembers() {
    return strategy.loadMembers();
  }

  /**
   * Persists the members.
   *
   * @param members - The members to persist.
   */
  public boolean persistMembers(List<Member> members) {
    return strategy.persistMembersBeforeExit(members);
  }

  @Override
  public boolean persistMembersBeforeExit(List<Member> members) {
    return strategy.persistMembersBeforeExit(members);
  }
}
