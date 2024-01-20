package com.controller;

import com.controller.model.Control;
import com.model.StuffLendingSystem;
import com.view.AddMemberView;
import com.view.model.View;

/**
 * The Add Member controller.
 */
public class AddMemberControl implements Control {
  StuffLendingSystem stuffSystem;
  AddMemberView view;
  String name;
  String email;
  String mobile;

  /**
   * Creates a new AddMemberControl.
   *
   * @param stuffSystem - The stuff system.
   * @param view        - The view.
   */
  public AddMemberControl(StuffLendingSystem stuffSystem, View view) {
    this.stuffSystem = stuffSystem;
    this.view = (AddMemberView) view;
    this.name = null;
  }

  @Override
  public boolean run() {
    while (!finishedGettingData()) {
    }
    return true;
  }

  private boolean finishedGettingData() {
    boolean finished = false;

    if (name == null) {
      name = view.getName();
    }

    boolean emailValid = false;
    while (!emailValid) {
      email = view.getEmail();
      if (email.equals("x")) {
        return true;
      }
      emailValid = stuffSystem.validateEmail(email);
    }

    boolean mobileValid = false;
    while (!mobileValid) {
      mobile = view.getMobile();
      mobileValid = stuffSystem.validateMobile(mobile);
    }

    boolean memberOk = stuffSystem.addNewMember(name, email, mobile);
    if (memberOk) {
      finished = true;
    } else {
      view.displayError("Member Creation Error");
    }

    return finished;
  }
}
