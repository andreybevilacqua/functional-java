package sales;

public interface QuantityOfInterest {

  String getName();

  /**
   * Expected value for a particular month
   * @param time month, 1-12
   * @return expected value
   */
  double valueAt(final int time);
}
