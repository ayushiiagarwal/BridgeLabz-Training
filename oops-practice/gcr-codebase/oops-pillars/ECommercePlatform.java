interface Taxable{
    double calculateTax();
    void getTaxDetails();
}

abstract class Product{
    private int productID;
    private String name;
    private double price;

    Product(int productID, String name, double price){
        this.productID = productID;
        this.name = name;
        this.setPrice(price);
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if(price >= 0)
            this.price = price;
    }
    
    public abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable{
    public Electronics(int productID, String name, double price){
        super(productID, name, price);
    }

    @Override
    public double calculateDiscount(){
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax(){
        return getPrice() * 0.15;
    }

    @Override
    public void getTaxDetails(){
        System.out.println("Tax Category: Electronics- \n10% discount \n15% tax");
    }
}

class CLothing extends Product{
    public CLothing(int productID, String name, double price){
        super(productID, name, price);
    }

    @Override
    public double calculateDiscount(){
        return getPrice() * 0.15;
    }
}

class Groceries extends Product{
    public Groceries(int productID, String name, double price){
        super(productID, name, price);
    }

    @Override
    public double calculateDiscount(){
        return getPrice() * 0.10;
    }
}

public class ECommercePlatform {
    public static void finalPrices(Product[] products){
        for(Product p : products){
            double discount = p.calculateDiscount();
            double tax = 0;

            if(p instanceof Taxable)
                tax = ((Taxable) p).calculateTax();

            double Price = p.getPrice() + tax - discount;
            System.out.println("Product: " + p.getName() + " Price: " + Price);
        }
    }
    public static void main(String[] args) {
        Product[] products = {new Electronics(101, "LCD", 50000.0),
                              new CLothing(201, "Jacket", 2000.0),
                            new Groceries(301, "Corn Flakes", 500.0)
        };

       finalPrices(products);
    }
}
