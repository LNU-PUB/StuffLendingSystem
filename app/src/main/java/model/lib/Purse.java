package model.lib;

/**
 * Represents a purse of credits.
 */
public class Purse {
  private int balance;

  public Purse(int balance) {
    this.credit(balance);
  }

  public Purse (){
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
