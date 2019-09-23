package improving_streams;

import improving_streams.random.RandomSale;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Example {

  public static void main(final String[] main) {
    System.out.println("Who bought a carrot? "
        + carrotCustomer().orElse("I can't say."));

    long saleCount = saleStream().count();
    System.out.println("Count of sales: " + saleCount);

    // any sales over $100?
    Supplier<DoubleStream> totalStream = () -> saleStream()
        .parallel()
        .mapToDouble(Sale::total);
    boolean bigSaleDay = totalStream
        .get()
        .parallel()
        .anyMatch(total -> total > 100.00);
    System.out.println("Big sales day? " + bigSaleDay);

    // maximum sale amount?
    DoubleSummaryStatistics stats = totalStream
        .get()
        .parallel()
        .summaryStatistics();
    System.out.println("Max sale amount: " + stats.getMax());
    System.out.println("Stats on total: " + stats);

    // how many items were sold today?
    Supplier<Stream<Item>> itemStream = () -> saleStream()
        .parallel()
        .flatMap(sale -> sale.items.stream());
    long itemCount = itemStream
        .get()
        .count();
    System.out.println("Count of items: " + itemCount);

    // which diff items we sold today?
    List<String> uniqueItems = itemStream
        .get()
        .parallel()
        .map(item -> item.identity)
        .distinct()
        .collect(Collectors.toList());
    System.out.println("Count of distinct items: " + uniqueItems);

    // summarize sales by store
    Map<String, DoubleSummaryStatistics> summary =
        saleStream()
            .parallel()
            .collect(Collectors.groupingBy(sale ->
                    Thread.currentThread().getName(),
            Collectors.summarizingDouble(Sale::total)));

    System.out.println("Summary by thread: " + summary);
    summary
        .keySet()
        .stream()
        .sorted()
        .forEach(store ->
            System.out.println(store + " stats: " + summary.get(store)));
  }

  static Stream<Sale> saleStream() {
    return RandomSale.streamOf(300000);
  }

  static Optional<Sale> findSaleOf(String itemName) {
    return saleStream().filter(sale ->
        sale.items.stream().anyMatch(item ->
            item.identity.equals(itemName)))
        .findFirst();
  }

  // Customer who bought a carrot
  static Optional<String> carrotCustomer() {
    return findSaleOf("carrot").flatMap(sale -> sale.customer);
  }

  // Store that sold a carrot
  static Optional<Store> carrotStore() {
    return findSaleOf("carrot").map(sale -> sale.store);
  }

}
