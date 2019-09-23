package improving_streams.random;

import java.util.Random;

public class RandomUtil {
  private static Random random = new Random();

  static <A> A randomElement(A[] as) {
    int randomStore = random.nextInt(as.length);
    return as[randomStore];
  }
}
