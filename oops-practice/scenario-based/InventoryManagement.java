import java.util.ArrayList;
import java.util.List;

class OutOfStockException extends Exception{
    public OutOfStockException(String message){
        super(message);
    }
}

interface AlertService{
    void generateAlert(InventoryProduct product);
}

class InventoryProduct{
    private String productId;
    private String productName;
    private int stock;

    public InventoryProduct(String productId, String productName, int stock){
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
    }

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public int getStock(){
        return stock;
    }

    public void updateStock(int quantity) throws OutOfStockException{
        if(stock + quantity < 0)
            throw new OutOfStockException(productName + ", Product Out of Stock");

        stock += quantity;
    }
}

public class InventoryManagement {
    private List<InventoryProduct> products;
    private AlertService alertService;
    private static final int stockLimit = 50;

    public InventoryManagement(AlertService alertService){
        this.products = new ArrayList<>();
        this.alertService = alertService;
    }

    public void addProduct(InventoryProduct product){
        products.add(product);
        System.out.println("Product Added: " + product.getProductName());
    }

    public void updateProductStock(String productId, int quantity) throws OutOfStockException{
        for(InventoryProduct p : products){
            if(p.getProductId().equals(productId)){
                p.updateStock(quantity);

                if(p.getStock() <= stockLimit){
                    alertService.generateAlert(p);
                }
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    public void displayDetails(){
        for(InventoryProduct p : products){
            System.out.println(p.getProductName() + ", Stock: " + p.getStock());
        }
    }
    public static void main(String[] args) {
        AlertService alertService = new AlertService() {
            @Override
            public void generateAlert(InventoryProduct product){
                System.out.println("Low Stock Alert: " + product.getProductName() +
            " (Stock: " + product.getStock() + ")");
            }
        };
        InventoryManagement inventory = new InventoryManagement(alertService);

        InventoryProduct p1 = new InventoryProduct("P101", "Laptop", 10);
        InventoryProduct p2 = new InventoryProduct("P102", "Mouse", 6);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try {
            inventory.updateProductStock("P101", -6);
            inventory.updateProductStock("P102", -4);
            inventory.updateProductStock("P102", -5); 
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        inventory.displayDetails();
    }
}
