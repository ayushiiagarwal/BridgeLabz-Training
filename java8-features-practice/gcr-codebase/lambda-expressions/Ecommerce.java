import java.util.*;

class Product {
    String name;
    int price;
    double rating;
    int discount;

    Product(String name, int price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString(){
        return name + " | Price: " + price + 
        " | Rating: " + rating + " | Discount: " + discount;
    }
}

public class Ecommerce {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 20000, 4.8, 10));
        products.add(new Product("Laptop", 100000, 5.0, 15));
        products.add(new Product("Tablet", 30000, 3.1, 20));

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("\nSorted By price: ");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating: ");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p1.discount, p2.discount));
        System.out.println("\nSorted by discount: ");
        products.forEach(System.out::println);
    }
}