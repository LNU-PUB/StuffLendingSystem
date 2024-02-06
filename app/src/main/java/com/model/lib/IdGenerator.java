package com.model.lib;

import java.security.SecureRandom;

/**
 * Generates unique ids for objects.
 *
 * @param <T> - The type of object to generate ids for.
 */
public class IdGenerator<T extends Identifiable> {
  private final SecureRandom random;

  /**
   * Creates a new instance of the id generator.
   */
  public IdGenerator() {
    this.random = new SecureRandom();
  }

  /**
   * Generates a unique id for an object.
   *
   * @param list - The list of objects to check uniqueness against.
   * @return - A unique id.
   */
  public String generateId(Iterable<T> list) {
    while (true) {
      String id = generateRandomId();
      if (isUniqueId(id, list)) {
        return id;
      }
    }
  }

  private String generateRandomId() {
    // 6 alpha-numeric characters
    String alphaNumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder result = new StringBuilder(6);

    for (int i = 0; i < 6; i++) {
      int index = this.random.nextInt(alphaNumericCharacters.length());
      result.append(alphaNumericCharacters.charAt(index));
    }

    return result.toString();
  }

  private boolean isUniqueId(String id, Iterable<T> list) {
    if (id == null || id.length() != 6) {
      return false;
    }

    for (T t : list) {
      if (t.getId().equals(id)) {
        return false;
      }
    }

    return true;
  }
}
