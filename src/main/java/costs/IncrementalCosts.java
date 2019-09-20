package costs;

import functions.QuantityOfInterest;
import functions.FunctionOverTime;

public class IncrementalCosts implements QuantityOfInterest {

  private final FunctionOverTime valueFunction;

  public IncrementalCosts(FunctionOverTime valueFunction) {
    this.valueFunction = valueFunction;
  }

  @Override
  public String getName() {
    return "Incremental Costs";
  }

  @Override
  public double valueAt(int time) {
    return valueFunction.valueAt(time);
  }
}
