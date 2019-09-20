public class Profit implements QuantityOfInterest {

  private final Sales sales;
  private final IncrementalCosts incrementalCosts;
  private final FixedCosts fixedCosts;

  public Profit(Sales sales, IncrementalCosts incrementalCosts, FixedCosts fixedCosts){
    this.sales = sales;
    this.incrementalCosts = incrementalCosts;
    this.fixedCosts = fixedCosts;
  }

  public String getName() {
    return "Profit!!!";
  }

  public double valueAt(final int time) {
    return sales.valueAt(time) -
        (incrementalCosts.valueAt(time) + fixedCosts.valueAt(time));
  }
}
