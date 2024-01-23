package com.view.model;

import com.model.MemberRepository;

/**
 * List view interface for displaying a list of items dynamic typing.
 */
public interface ListView<T> extends View {
  public T getInput();
}
