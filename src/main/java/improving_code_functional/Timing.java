package improving_code_functional;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Timing {

  static <A> A timed(String description, Supplier<A> code) { // Just a default consumer
    Consumer<String> defaultOutput = System.out::println;
    return timed(description, defaultOutput, code);
  }

  static <A> A timed(String description, Consumer<String> output, Supplier<A> code) {
    final Date beforeCosts = new Date();

    A result = code.get();

    final long duration = new Date().getTime() - beforeCosts.getTime();
    printResult(output, description, duration);

    return result;
  }

  private static void printResult(Consumer<String> output, String description, long duration) {
    output.accept(description + " took " + duration  + " milliseconds");
  }

}
