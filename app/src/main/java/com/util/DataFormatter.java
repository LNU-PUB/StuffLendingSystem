package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to encode letters to numbers and decode numbers to the
 * corresponding letters.
 */
public class DataFormatter {
  /**
   * Encodes the selectorLetter to a list of numbers.
   *
   * @param selectorLetter - the selector letter to encode.
   * @return the list of numbers.
   */
  public List<String> selectorEncoder(String selectorLetter) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    // List from 01 ro 26
    List<String> numbers = List.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
        "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");
    List<String> selectorNumber = new ArrayList<String>();

    if (selectorLetter == null || selectorLetter.isEmpty()) {
      throw new IllegalArgumentException("The selector letter cannot be null or empty.");
    }

    selectorLetter = selectorLetter.trim();
    selectorLetter = selectorLetter.toLowerCase();

    if (!selectorLetter.matches("^[a-zA-Z]+$")) {
      throw new IllegalArgumentException("The selector input is invalid.");
    }

    // For each letter in the selectorLetter convert it to the number that
    // corresponds to the position in the alphabet
    for (int i = 0; i < selectorLetter.length(); i++) {
      int index = alphabet.indexOf(selectorLetter.charAt(i));
      selectorNumber.add(numbers.get(index));
    }

    return selectorNumber;
  }

  /**
   * Decodes the selectorNumber to the corresponding letter.
   *
   * @param selectorNumber - the selector number to decode.
   * @return the selector letter.
   */
  public String selectorDecoder(String selectorNumber) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    // List from 01 ro 26
    List<String> numbers = List.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
        "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");

    if (selectorNumber == null || selectorNumber.isEmpty() || selectorNumber.length() % 2 != 0) {
      throw new IllegalArgumentException("The selector number cannot be null or empty.");
    }

    selectorNumber = selectorNumber.trim();
    selectorNumber = selectorNumber.toLowerCase();

    StringBuilder selectorLetter = new StringBuilder();
    for (int i = 0; i < selectorNumber.length(); i += 2) {
      String segment = selectorNumber.substring(i, i + 2);
      int index = numbers.indexOf(segment);
      System.out.println("Test index: " + index);
      if (index == -1) {
        throw new IllegalArgumentException("The selector input is invalid.");
      }
      selectorLetter.append(alphabet.charAt(index));
    }

    return selectorLetter.toString();
  }
}
