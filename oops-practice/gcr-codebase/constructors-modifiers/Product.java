public class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String productName, double price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Product(){
    //     productName = "Cookies";
    //     price = 500.0;
    // }

    static void displayTotalProducts(){
        System.out.println("Total Products: " + totalProducts);
    }

    void display(){
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Cookies", 500.0);
        Product p2 = new Product("Macroni", 450.0);
        Product p3 = new Product("Cheese", 550.0);

        p1.display();
        p2.display();
        p3.display();
        displayTotalProducts();
    }
}

