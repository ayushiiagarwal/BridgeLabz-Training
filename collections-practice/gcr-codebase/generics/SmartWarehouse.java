import java.util.*;

class Storage<T extends WarehouseItem>{
    List<T> items = new ArrayList<>();
    void addItem(T item){
        items.add(item);
    }
    List<T> getItems(){
        return items;
    }
}

class WarehouseUtility{
    public static void displayDetails(List<? extends WarehouseItem> list){
        for(WarehouseItem i : list)
            i.display();
    }
}

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name){
        this.name = name;
    }
    abstract void display();
}

class Electronics extends WarehouseItem{
    Electronics(String name){
        super(name);
    }
    void display(){
        System.out.println(name);
    }
}

class Groceries extends WarehouseItem{
    Groceries(String name){
        super(name);
    }
    void display(){
        System.out.println(name);
    }
}

class Furniture extends WarehouseItem{
    Furniture(String name){
        super(name);
    }
    void display(){
        System.out.println(name);
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop"));
        electronics.addItem(new Electronics("Phone"));
        electronics.addItem(new Electronics("Television"));

        Storage<Groceries> grocery = new Storage<>();
        grocery.addItem(new Groceries("Peanut Butter"));
        grocery.addItem(new Groceries("Chocolate Syrup"));
        grocery.addItem(new Groceries("Milk"));

        Storage<Furniture> furniture = new Storage<>();
        furniture.addItem(new Furniture("Chair"));
        furniture.addItem(new Furniture("Table"));
        furniture.addItem(new Furniture("Couch"));
        
        System.out.println("Electronic Items: ");
        WarehouseUtility.displayDetails(electronics.getItems());

        System.out.println("\nGrocery Items: ");
        WarehouseUtility.displayDetails(grocery.getItems());

        System.out.println("\nFurniture Items: ");
        WarehouseUtility.displayDetails(furniture.getItems());
    }
}