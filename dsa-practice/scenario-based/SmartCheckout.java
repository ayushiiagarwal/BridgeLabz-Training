import java.util.*;

class Customer{
    String name;
    List<String> items;

    Customer(String name, List<String> items){
        this.name = name;
        this.items = items;
    }
}

public class SmartCheckout{
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();

        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Butter", 50);
        prices.put("Bread", 40);
        prices.put("Cereals", 10);

        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("Butter", 10);
        stock.put("Bread", 5);
        stock.put("Cereals", 30);

        queue.add(new Customer("Adam", Arrays.asList("Butter", "Bread")));
        queue.add(new Customer("Liam", Arrays.asList("Cereals", "Butter")));

        while(!queue.isEmpty()){
            Customer c = queue.poll();
            int totalBill = 0;

            System.out.println("Customer: " + c.name);

            for (String item : c.items) {
                if(stock.get(item) > 0){
                    totalBill += prices.get(item);
                    stock.put(item, stock.get(item) - 1);
                }
                else
                    System.out.println(item + " out of stock");
            }

            System.out.println("Total Bill: " + totalBill);
            System.out.println();
        }
    }
}