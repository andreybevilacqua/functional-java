package improving_code_functional;

import java.util.Date;
import java.util.function.Supplier;

class Timing {

  static Double timed(String description, Supplier<Double> code) {
    final Date beforeCosts = new Date();
    Double result = code.get();
    final long duration = new Date().getTime() - beforeCosts.getTime();
    System.out.println(description + " took " + duration  + " milliseconds");

    return result;
  }

}
