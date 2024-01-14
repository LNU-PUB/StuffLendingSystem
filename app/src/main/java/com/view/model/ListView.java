package com.view.model;

import com.model.StuffLendingSystem;

public interface ListView<T> {
  public void displayMenu(StuffLendingSystem stuffSystem);

  public T getInput();
}
