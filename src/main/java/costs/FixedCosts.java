package costs;

import functions.QuantityOfInterest;
import functions.FunctionOverTime;

public class FixedCosts implements QuantityOfInterest {

  private final FunctionOverTime valueFunction;

  public FixedCosts(FunctionOverTime valueFunction) {
    this.valueFunction = valueFunction;
  }

  @Override
  public String getName() {
    return "Fixed Costs";
  }

  @Override
  public double valueAt(int time) {
    return valueFunction.valueAt(time);
  }
}
