package model.lib;

/**
 * Represents a telephone.
 */
public class Telephone {
  private final String telephone;

  /**
   * Constructor.
   *
   * @param telephone - The telephone.
   */
  public Telephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Gets the telephone.
   *
   * @return - The telephone.
   */
  public String getTelephone() {
    return telephone;
  }
}
