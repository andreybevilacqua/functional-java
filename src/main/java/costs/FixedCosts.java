package costs;

public class FixedCosts extends PolynomialQuantity {

  public FixedCosts(double[] coefficients) {
    super(coefficients);
  }

  @Override
  public String getName() {
    return "Fixed Costs";
  }
}
