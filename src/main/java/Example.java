import costs.FixedCosts;
import costs.IncrementalCosts;
import sales.Profit;
import sales.Sales;

public class Example {

  private final static double[] EXPECTED_SALES_JAN_TO_DEC =
      new double[] {42.0, 45.6, 43.6, 50.2, 55.6, 54.7, 58.0, 57.3, 62.0, 60.3, 71.2, 88.8};

  public static void main(final String[] args) {

    final FixedCosts fixedCosts = new FixedCosts(15.0);
    final IncrementalCosts incrementalCosts = new IncrementalCosts(5.1, 0,15);

    final Profit profit = new Profit(sales, incrementalCosts, fixedCosts);

    final Sales sales = new Sales(EXPECTED_SALES_JAN_TO_DEC);

    double total = 0;
    for(int i = 1; i <= 12; i++) {
      total += profit.valueAt(i);
    }

    System.out.println("Total profits for the year: " + total);
  }
}
