package com.controller.model.util;

/**
 * Exception for when a lending contract could not be created.
 */
public class FailedToCreateLendingContractException extends Exception {

  /**
   * Constructor.
   *
   * @param message - the message.
   */
  public FailedToCreateLendingContractException(String message) {
    super(message);
  }

  /**
   * Constructor.
   *
   * @param message - the message.
   * @param cause   - the cause.
   */
  public FailedToCreateLendingContractException(String message, Throwable cause) {
    super(message, cause);
  }
}
