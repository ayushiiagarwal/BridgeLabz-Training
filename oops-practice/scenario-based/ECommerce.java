import java.util.ArrayList;
import java.util.List;

class PaymentFailedException extends Exception{
    public PaymentFailedException(String message){
        super(message);
    }
}

interface Payment{
    void payment(double amount) throws PaymentFailedException;
}

class CardPayment implements Payment{
    @Override
    public void payment(double amount) throws PaymentFailedException{
        System.out.println("Card Payment of Rs." + amount + "...");
        if(amount > 5000.0) throw new PaymentFailedException("Card Limit Exceeded");

        System.out.println("Card Payment Successful\n");
    }
}

class UPIPayment implements Payment{
    @Override
    public void payment(double amount){
        System.out.println("UPI Payment of Rs." + amount + "...");
        System.out.println("UPI Payment Successful\n");
    }
}

class WalletPayment implements Payment{
    @Override
    public void payment(double amount){
        System.out.println("Wallet Payment of Rs." + amount + "...");
        System.out.println("Wallet Payment Successful\n");
    }
}

class Product{
    private String productId, productName;
    double price;

    public Product(String productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public double getPrice(){
        return price;
    }

    public void getDetails(){
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: " + getPrice());
    }
}

class Order{
    private String orderId;
    private Product product;
    private String status;

    public Order(String orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.status = "PENDING";
    }

    public void completeOrder() { 
        this.status = "PLACED"; 
    }

    public void cancelOrder(){ 
        this.status = "CANCELLED"; 
    }
    
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product: " + product.getProductName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class ECommerce{
    public static void main(String[] args) {
        Product laptop = new Product("P01", "MacBook Pro", 100000.0);
        Product phone = new Product("P02", "iPhone 15", 80000.0);
        
        List<Order> orderHistory = new ArrayList<>();

        System.out.println("--- Ordered a Laptop ---");
        laptop.getDetails();
        System.out.println();
        placeOrder("ORD101", laptop, new UPIPayment(), orderHistory);

        System.out.println("\n--- Ordered a Phone ---");
        phone.getDetails();
        System.out.println();
        placeOrder("ORD102", phone, new CardPayment(), orderHistory);

        System.out.println("\n--- Order Tracking ---");
        for (Order o : orderHistory) {
            o.displayOrder();
        }
    }

    public static void placeOrder(String id, Product p, Payment method, List<Order> history) {
        Order newOrder = new Order(id, p);
        try {
            method.payment(p.getPrice());
            newOrder.completeOrder();
            System.out.println("Order Confirmed!");
        } catch (PaymentFailedException e) {
            newOrder.cancelOrder();
            System.err.println("Order Failed: " + e.getMessage());
        } finally {
            history.add(newOrder);
        }
    }
}