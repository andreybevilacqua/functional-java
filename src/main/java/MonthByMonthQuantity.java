abstract class MonthByMonthQuantity implements QuantityOfInterest {

  private final double[] values;

  protected MonthByMonthQuantity(double[] values) {this.values = values;}

  public double valueAt(final int time) {
    return values[time -1];
  }
}
