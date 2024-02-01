package com.model.db;

import com.model.Member;
import java.util.List;

/**
 * Handles data access and storage for Member objects.
 */
public interface DataHandlerMember {
  public List<Member> getMembers();

  public boolean storeMembers(List<Member> members);
}