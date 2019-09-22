package improving_code_functional;

import java.util.Date;
import java.util.function.Supplier;

class Timing {

  static <A> A timed(String description, Supplier<A> code) {
    final Date beforeCosts = new Date();

    A result = code.get();

    final long duration = new Date().getTime() - beforeCosts.getTime();
    System.out.println(description + " took " + duration  + " milliseconds");

    return result;
  }

}
