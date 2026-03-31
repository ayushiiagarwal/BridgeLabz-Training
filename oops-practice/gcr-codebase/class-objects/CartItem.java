public class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double cost, int qty) {
        itemName = name;
        price = cost;
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    void removeItem(int qty) {
        if(quantity >= qty){
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        }
    }

    double calculateTotal() {
        return price * quantity;
    }

    void displayCartDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
    public static void main(String[] args) {
        CartItem cart = new CartItem();

        cart.itemName = "Laptop";
        cart.price = 999.99;
        cart.quantity = 1;

        cart.displayCartDetails();
        cart.addItem("Laptop", 999.99, 1);
        cart.removeItem(1);
        System.out.println("Total Cost : $" + cart.calculateTotal());
        
    }
}
