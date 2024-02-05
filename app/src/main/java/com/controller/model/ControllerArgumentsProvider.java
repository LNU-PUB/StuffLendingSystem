package com.controller.model;

import com.model.MemberServices;

/**
 * Class holding common arguments for controllers.
 */
public interface ControllerArgumentsProvider {
  public InputService getInputService();

  public MemberServices getMemberServices();

  public Language getLanguage();
}
