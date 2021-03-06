package improving_code_functional;

import static improving_code_functional.Timing.timed;
import static java.lang.Math.random;

public class Example {

  public static void main(final String[] args) {
    final Double costs = timed("Cost calculation", Example::calculateCosts);
    final Double revenue = timed("Revenue calculation", Example::calculateRevenue);
    final Double profit = timed("Profit calculation", () -> calculateProfit(costs, revenue));
    final String proveThatYouCanExecuteAnyFunction = timed("String calculation", Example::calculateString);

    System.out.println("Profit = $" + profit);
  }

  private static Double calculateCosts() {
    pretendToWorkHard();
    return 4567.3;
  }

  private static Double calculateRevenue() {
    pretendToWorkHard();
    return 23413.2;
  }

  private static String calculateString() {
    pretendToWorkHard();
    return "My important String";
  }

  private static Double calculateProfit(Double costs, Double revenue) {
    pretendToWorkHard();
    return revenue - costs;
  }


  private static void pretendToWorkHard() {
    try {
      Thread.sleep((long) (random() * 100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
