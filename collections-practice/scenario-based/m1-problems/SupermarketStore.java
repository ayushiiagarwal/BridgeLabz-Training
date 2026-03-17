import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product{
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void display();

    double totalValue(){
        return price * quantity;
    }
}

class Electronics extends Product{
    int warranty;

    Electronics(String name, double price, int quantity, int warranty){
        super(name, price, quantity);
        this.warranty = warranty;
    }

    void display(){
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product{
    String size;

    Clothing(String name, double price, int quantity, String size){
        super(name, price, quantity);
        this.size = size;
    }

    void display(){
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
    }
}

public class SupermarketStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Product> inventory = new ArrayList<>();

        for(int i=0;i<n;i++){
            String line = sc.nextLine().trim();

            if(line.isEmpty()){
                i--;
                continue;
            }

            String[] data = line.split(",\\s*");

            String type = data[0];

            if(type.equals("Electronics")){
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int qty = Integer.parseInt(data[3]);
                int warranty = Integer.parseInt(data[4]);

                inventory.add(new Electronics(name, price, qty, warranty));
                System.out.println("Product added to inventory: " + name);
            }
            else if(type.equals("Clothing")){
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int qty = Integer.parseInt(data[3]);
                String size = data[4];

                inventory.add(new Clothing(name, price, qty, size));
                System.out.println("Product added to inventory: " + name);
            }
        }

        System.out.println("\nInventory:");
        double total = 0;

        for(Product p : inventory){
            p.display();
            total += p.totalValue();
        }

        System.out.printf("\nTotal value of the inventory: %.2f\n", total);
    }
}
