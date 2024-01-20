package com.controller.model;

import java.util.Scanner;

/**
 * Input service.
 */
public class InputService {
  private final Scanner scanner;

  /**
   * Creates a new instance of the input service.
   */
  public InputService() {
    this.scanner = new Scanner(System.in, "UTF-8");
  }

  /**
   * Reads a line of input from the user.
   *
   * @return The line of input.
   */
  public String readLine() {
    return scanner.nextLine();
  }
}
