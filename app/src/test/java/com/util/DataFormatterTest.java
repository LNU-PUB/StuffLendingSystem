package com.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataFormatterTest {

  private DataFormatter formatter;

  @BeforeEach
  void setUp() {
    formatter = new DataFormatter();
  }

  // ***** Encoder tests *****
  @Test
  void testSelectorEncoderWithValidInput() {
    List<String> encoded = formatter.selectorEncoder("abc");
    assertEquals(List.of("01", "02", "03"), encoded, "Encoding 'abc' should return [01, 02, 03]");
  }

  @Test
  void testSelectorEncoderWithNullInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorEncoder(null),
        "The selector letter cannot be null or empty.");
  }

  @Test
  void testSelectorEncoderWithEmptyInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorEncoder(""),
        "The selector letter cannot be null or empty.");
  }

  @Test 
  
  void testSelectorEncoderWithInvalidInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorEncoder("!"),
        "The selector letter cannot be null or empty.");
  }

  @Test
  void testSelectorEncoderWithNonAlphabeticInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorEncoder("123"),
        "The selector letter cannot be null or empty.");
  }

  // ***** Decoder tests *****

  @Test
  void testSelectorDecoderWithValidInput() {
    String decoded = formatter.selectorDecoder("010203");
    assertEquals("abc", decoded, "Decoding '010203' should return 'abc'");
  }

  @Test
  void testSelectorDecoderWithNullInput() {
    assertThrows(IllegalArgumentException.class, () -> formatter.selectorDecoder(null),
        "Decoding null should return an empty string");
  }

  @Test
  void testSelectorDecoderWithEmptyInput() {
    assertThrows(IllegalArgumentException.class, () -> formatter.selectorDecoder(""),
        "Decoding an empty string should return an empty string");
  }

  @Test
  void testSelectorDecoderWithInvalidInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorDecoder("!"),
        "The selector input is invalid.");

  }

  @Test
  void testSelectorDecoderWithNonNumericInput() {
    assertThrows(IllegalArgumentException.class,
        () -> formatter.selectorDecoder("abc"),
        "The selector letter cannot be null or empty.");
  }
}
