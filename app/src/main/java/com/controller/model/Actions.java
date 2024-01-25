package com.controller.model;

import java.util.List;

/**
 * Interface for actions.
 */
public interface Actions {
  public String getName();

  public char getSelector();

  public List<Character> getValidSelectors();
}
