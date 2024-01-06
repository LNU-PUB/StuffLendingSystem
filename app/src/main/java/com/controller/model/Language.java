package com.controller.model;

/**
 * The languages supported by the application.
 */
public enum Language {
  ENG("English", "en", "US"),
  SWE("Svenska", "sv", "SE");

  private String name;
  private String language;
  private String country;

  Language(String name, String language, String country) {
    this.name = name;
    this.language = language;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public String getLanguage() {
    return language;
  }

  public String getCountry() {
    return country;
  }
}
