import functions.QuantityOfInterest;
import functions.FunctionOverTime;

public class Sales implements QuantityOfInterest {

  private final FunctionOverTime valueFunction;

  public Sales(FunctionOverTime valueFunction) {
    this.valueFunction = valueFunction;
  }

  @Override
  public String getName() {
    return "Sales";
  }

  @Override
  public double valueAt(int time) {
    return valueFunction.valueAt(time);
  }
}
