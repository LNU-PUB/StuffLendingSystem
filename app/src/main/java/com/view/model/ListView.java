package com.view.model;

import com.model.StuffLendingSystem;

/**
 * List view interface for displaying a list of items dynamic typing.
 */
public interface ListView<T> extends View {
  public T getInput();
}
