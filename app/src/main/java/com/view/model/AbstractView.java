package com.view.model;

import com.controller.model.Language;
import com.view.ViewProvider;

/**
 * Input interface.
 */
public abstract class AbstractView extends AbstractCommonView implements ViewProvider {

  /**
   * Constructs a new instance.
   *
   * @param language - the language
   * @param bundleName - the bundle name
   */
  protected AbstractView(Language language, String bundleName) {
    super(language, bundleName);
  }
}
