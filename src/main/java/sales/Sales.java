package sales;

public class Sales extends MonthByMonthQuantity {

  public Sales(final double[] values) { super(values);}

  public String getName() {
    return "Expected sales";
  }
}