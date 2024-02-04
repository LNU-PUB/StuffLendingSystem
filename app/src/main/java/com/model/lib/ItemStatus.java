package com.model.lib;

public enum ItemStatus {
  AVAILABLE("available"),
  BORROWED("borrowed"),
  BROKEN("broken"),
  LOST("lost");

  private final String status;

  ItemStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
