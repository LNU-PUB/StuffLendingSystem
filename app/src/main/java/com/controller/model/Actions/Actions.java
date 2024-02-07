package com.controller.model.actions;

import java.util.List;

/**
 * Interface for actions.
 */
public interface Actions {
  public String getName();

  public String getSelector();

  public List<String> getValidSelectors();
}
