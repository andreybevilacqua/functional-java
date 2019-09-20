package costs;

import sales.QuantityOfInterest;

public class PolynomialQuantity implements QuantityOfInterest {

  private final double[] coefficients;

  public PolynomialQuantity(double[] coefficients) {this.coefficients = coefficients;}

  public String getName() {
    return null;
  }

  public double valueAt(final int time) {
    double value = 0.0;
    for (int i = 0; i < coefficients.length; i++) {
      value += coefficients[i] * Math.pow(time, i);
    }
    return value;
  }
}
