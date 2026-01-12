import java.util.ArrayList;
import java.util.List;

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

interface Payment {
    void processPayment(double amount) throws PaymentFailedException;
}

class CardPayment implements Payment {
    @Override
    public void processPayment(double amount) throws PaymentFailedException {
        if (amount > 5000) throw new PaymentFailedException("Card limit exceeded.");
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class UPIPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

class WalletPayment implements Payment {
    private double balance = 10000.0; 

    @Override
    public void processPayment(double amount) throws PaymentFailedException {
        if (amount > balance) {
            throw new PaymentFailedException("Insufficient Wallet Balance! Required: " + amount);
        }
        balance -= amount;
        System.out.println("Paid $" + amount + " using Digital Wallet.");
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }
}

class Order {
    private String orderId;
    private Product product;
    private String status;

    public Order(String orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.status = "PENDING";
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
    
    @Override
    public String toString() {
        return "Order ID: " + orderId + "\nItem: " + product.getName() + "\nStatus: " + status;
    }
}

class Customer {
    private String username;
    private List<Order> myOrders;

    public Customer(String username) {
        this.username = username;
        this.myOrders = new ArrayList<>();
    }

    public void placeOrder(String orderId, Product p, Payment method) {
        Order newOrder = new Order(orderId, p);
        System.out.println("\nCustomer " + username + " ordered " + p.getName());
        
        try {
            method.processPayment(p.getPrice());
            newOrder.setStatus("PLACED");
        } catch (PaymentFailedException e) {
            newOrder.setStatus("CANCELLED");
            System.out.println(e.getMessage());
        } finally {
            myOrders.add(newOrder);
        }
    }

    public void viewOrderHistory() {
        System.out.println("\n--- Order History for " + username + " ---");
        for (Order o : myOrders){
            System.out.println(o);
            System.out.println();
        }
    }
}

public class ECommerce {
    public static void main(String[] args) {
        
        Product phone = new Product("iPhone", 80000.0);
        Product book = new Product("To Hate Adam Connor", 4500.0);
        Product laptop = new Product("MacBook Pro", 100000.0);

        Customer user1 = new Customer("Lucy");

        user1.placeOrder("ORD001", phone, new WalletPayment());

        user1.placeOrder("ORD002", book, new UPIPayment());

        user1.placeOrder("ORD003", laptop, new CardPayment());

        user1.viewOrderHistory();
    }
}