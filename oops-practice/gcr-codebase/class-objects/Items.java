public class Items {
    String itemCode, itemName;
    Double price;

    Items(String itemCode, Double price, String itemName){
        this.itemCode = itemCode;
        this.price = price;
        this.itemName = itemName;

    }

    public void display(){
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Price: " + price);
        System.out.println("Item Name: " + itemName);
    }
    public static void main(String[] args) {
        Items item1 = new Items("01AA", 500.0, "Water Bottle");
        Items item2 = new Items("01BB", 700.0, "Rice");
        Items item3 = new Items("02AA", 400.0, "Black Board");

        item1.display();
        System.out.println("--------------------------");
        item2.display();
        System.out.println("--------------------------");
        item3.display();
        System.out.println("--------------------------");

    }
}
