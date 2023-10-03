package model.lib;

/**
 * Represents a purse of credits.
 */
public class Purse {
  private int balance;

  /**
   * Constructor.
   *
   * @param balance - The balance of the purse.
   */
  public Purse(int balance) {
    if (Math.abs(balance) > 0) {
      this.credit(balance);
    } else {
      this.debit(balance);
    }
  }

  /**
   * Constructor.
   */
  public Purse() {
    this.balance = 0;
  }

  /**
   * Credits the purse.
   *
   * @param amount - The amount to credit.
   */
  public void credit(int amount) {
    int a = Math.abs(amount);
    balance += a;
  }

  /**
   * Debits the purse.
   *
   * @param amount - The amount to debit.
   */
  public void debit(int amount) {
    int a = Math.abs(amount);
    if (a > balance) {
      throw new IllegalArgumentException("Not enough money in purse");
    }
    balance -= a;
  }

  /**
   * Gets the balance.
   *
   * @return - The balance.
   */
  public int getBalance() {
    return balance;
  }
}
