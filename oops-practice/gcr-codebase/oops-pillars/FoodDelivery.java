interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void getItemDetails(){
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItems extends FoodItem implements Discountable{
    public VegItems(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice(){
        return getPrice() * getQuantity();
    }

    public double applyDiscount(){
        return calculateTotalPrice() * 0.15;
    }

    public String getDiscountDetails(){
        return "10% discount for Veg Items.";
    }
}

class NonVegItems extends FoodItem implements Discountable{
    public NonVegItems(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice(){
        return getPrice() * getQuantity() + 100.0;
    }

    public double applyDiscount(){
        return calculateTotalPrice() * 0.5;
    }

    public String getDiscountDetails(){
        return "5% discount for Non-Veg Items.";
    }
}

public class FoodDelivery{
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItems("Pasta", 100, 2),
            new NonVegItems("Chicken Biryani", 200, 1)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            if (item instanceof Discountable) {
                Discountable discount = (Discountable) item;
                System.out.println(discount.getDiscountDetails());
                System.out.println("Final Price after discount: " + (total - discount.applyDiscount()));
            }
            System.out.println();
        }
    }    
}