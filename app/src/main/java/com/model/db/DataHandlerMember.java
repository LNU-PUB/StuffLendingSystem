package com.model.db;

import java.util.List;

import com.model.Member;

/**
 * Handles data access and storage for Member objects.
 */
public interface DataHandlerMember {
  public List<Member> getMembers();

  public boolean storeMembers(List<Member> members);
}
