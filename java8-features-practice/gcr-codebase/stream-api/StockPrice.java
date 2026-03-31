import java.util.List;

public class StockPrice {
    public static void main(String[] args) {
        List<Double> prices = List.of(500.0, 600.0, 450.0, 6820.0);

        prices.stream()
        .forEach(price -> System.out.println("Stock Price: " + price));
    }
}
