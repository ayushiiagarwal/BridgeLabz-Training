class Product {
    int id;
    String name;
    int quantity;
    double price;
    Product next;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    Product head = null;

    public void addProduct(int id, String name, int quantity, double price) {
        Product newProduct = new Product(id, name, quantity, price);
        if (head == null) {
            head = newProduct;
        }
        else {
            Product temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newProduct;
        }
    }

    public void removeProduct(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Product temp = head;
        while (temp.next != null && temp.next.id != id){
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void updateStock(int id, int newQty) {
        Product temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Stock updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Product not found.");
    }

    public void displayInventory() {
        Product temp = head;
        while (temp != null) {
            System.out.println("Item Id: " + temp.id + " | Item Name: " + temp.name);
            System.out.println("Quantity: " + temp.quantity + " | Price: " + temp.price);
            System.out.println();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement product = new InventoryManagement();
        product.addProduct(1001, "Sketches", 50, 450.0);
        product.addProduct(1002, "Charcoal Powder", 30, 500.0);
        product.displayInventory();
        product.updateStock(1001, 100);
        product.removeProduct(1002);
        product.displayInventory();
    }
}
