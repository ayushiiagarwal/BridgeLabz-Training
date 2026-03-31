import java.util.*;

interface Category{
    String getCategory();
}

class BookCategory implements Category{
    public String getCategory(){
        return "Books";
    }
}

class ClothingCategory implements Category{
    public String getCategory(){
        return "Clothing";
    }
}

class GadgetCategory implements Category{
    public String getCategory(){
        return "Gadgets";
    }
}

class Product<T extends Category>{
    private String name;
    private double price;
    T category;

    public Product(String name, double price, T category){
        this.name=name;
        this.price=price;
        this.category=category;
    }

    double getPrice(){
        return price;
    }

    void setPrice(double price){
        this.price = price;
    }

    void display(){
        System.out.println("Product: " + name + "\nCategory: " 
        + category.getCategory() + "\nPrice: " + price);
    }
}

class Catalog{
    List<Product<? extends Category>> products = new ArrayList<>();

    void addProduct(Product<? extends Category> product){
        products.add(product);
    }

    List<Product<? extends Category>> getProducts(){
        return products;
    }
}

class DiscountUtility{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Verity", 1000, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Shirt", 600, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Phone", 45000, new GadgetCategory());
        
        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("Before Discount: \n");
        for(Product<? extends Category> p : catalog.getProducts()){
            p.display();
            System.out.println();
        }

        DiscountUtility.applyDiscount(book, 15);
        DiscountUtility.applyDiscount(shirt, 5);
        DiscountUtility.applyDiscount(phone, 10);

        System.out.println("----------------------------");
        System.out.println("\nAfter Discount: \n");
        for(Product<? extends Category> p : catalog.getProducts()){
            p.display();
            System.out.println();
        }
    }
}
