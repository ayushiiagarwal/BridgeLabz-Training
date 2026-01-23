import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> products = new HashMap<>();
        products.put("Peanut Butter", 300.0);
        products.put("Cheese", 450.0);
        products.put("Cookies", 200.0);

        LinkedHashMap<String, Double> ordered = new LinkedHashMap<>();
        ordered.put("Peanut Butter", 300.0);
        ordered.put("Cheese", 450.0);
        ordered.put("Cookies", 200.0);

        TreeMap<Double, String> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : ordered.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }

        System.out.println(products);
        System.out.println(ordered);
        System.out.println(sorted);
    }
}
