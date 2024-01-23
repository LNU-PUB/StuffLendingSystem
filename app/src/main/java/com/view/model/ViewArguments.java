package com.view.model;

import com.controller.model.Language;
import com.model.MemberRepository;

/**
 * Class holding common arguments for views.
 */
public class ViewArguments {
  private final String bundleName;
  private final Language language;
  private final MemberRepository stuffSystem;

  /**
   * Creates a new instance of the view arguments.
   *
   * @param bundleName   - The bundle name.
   * @param language     - The language.
   */
  public ViewArguments(MemberRepository stuffSystem, String bundleName, Language language) {
    this.bundleName = bundleName;
    this.language = language;
    this.stuffSystem = stuffSystem;
  }

  /**
   * Gets the bundle name.
   *
   * @return - The bundle name.
   */
  public String getBundleName() {
    return bundleName;
  }

  /**
   * Gets the language.
   *
   * @return - The language.
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Gets the stuff system.
   *
   * @return - The stuff system.
   */
  public MemberRepository getStuffSystem() {
    return stuffSystem;
  }

}
