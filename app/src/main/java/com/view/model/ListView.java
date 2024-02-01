package com.view.model;

/**
 * List view interface for displaying a list of items dynamic typing.
 */
public interface ListView<T> extends View {
  public T getInput();
}
