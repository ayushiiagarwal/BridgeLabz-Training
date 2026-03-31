import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order{
    private String name;
    private double totalAmount;

    public Order(String name, double totalAmount){
        this.name = name;
        this.totalAmount = totalAmount;
    }

    public String getName(){ return name; }
    public double getTotalAmount(){ return totalAmount; }

}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("Adam", 1500.0),
            new Order("Liam", 800.0),
            new Order("Olive", 2000.0)
        );

        Map<String, Double> map = orders.stream().collect(
                                Collectors.groupingBy(
                                    Order::getName,
                                    Collectors.summingDouble(
                                        Order::getTotalAmount)
                                ));

        map.forEach((name, amount) -> System.out.println(name + " - " + amount));
    }
}
