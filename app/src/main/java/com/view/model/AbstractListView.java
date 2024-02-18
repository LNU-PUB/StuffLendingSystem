package com.view.model;

import com.controller.model.Language;
import com.view.ListViewProvider;

/**
 * Common abstract base class for all List views.
 * Implements the ListViewProvider interface.
 */
public abstract class AbstractListView extends AbstractCommonView implements ListViewProvider {

  /**
   * Constructs a new instance.
   *
   * @param language - the language
   * @param bundleName - the bundle name
   */
  public AbstractListView(Language language, String bundleName) {
    super(language, bundleName);
  }
}
