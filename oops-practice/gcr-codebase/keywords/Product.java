public class Product {
    private static double discount = 10.0;
    private String productName;
    private double price;
    private int quantity;
    private final String productID;

    public Product(String productID, String productName, double price, int quantity){
        this.productID=productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

    }

    public void displayProductDetails(){
        if(this instanceof Product){
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");

            double discountedPrice = price - (price * discount/100);
            System.out.println("Price after Discount: $" + discountedPrice);
        }
        else
            System.out.println("Invalid Product");
    }

    public static void updateDiscount(double newDiscount){
        discount = newDiscount;
    }

    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop", 1200.0, 5);
        Product p2 = new Product("P002", "Smartphone", 800.0, 10);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
    }

}
