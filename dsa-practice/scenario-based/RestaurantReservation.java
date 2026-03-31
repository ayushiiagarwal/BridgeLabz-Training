import java.util.*;

class TableAlreadyReservedException extends Exception{
    TableAlreadyReservedException(String message){
        super(message);
    }
}

class Table{
    private int tableNumber;
    
    public Table(int tableNumber){
        this.tableNumber = tableNumber;
    }

    public int getTableNumber(){
        return tableNumber;
    }

    @Override
    public String toString(){
        return "Table: " + tableNumber;
    }
}

class Reservations{
    private String customerName;
    private int tableNumber;
    private String timeSlot;

    public Reservations(String customerName, int tableNumber, String timeSlot){
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }

    public String getName(){
        return customerName;
    }

    public String getTimeSlot(){
        return timeSlot;
    }

    public int getTableNumber(){
        return tableNumber;
    }

    public String toString(){
        return "Reservation for " + customerName + " at Table " + tableNumber + " during " + timeSlot;
    }
}

class Restaurant{
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservations> reservations = new ArrayList<>();

    public void addTable(Table table){
        tables.put(table.getTableNumber(), table);
    }

    public void reserveTable(String name, int tableNumber, String timeSlot) throws TableAlreadyReservedException{
        for(Reservations r : reservations){
            if(r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot))
                throw new TableAlreadyReservedException("Table " + tableNumber + " already reserved for " + timeSlot);
        }

        reservations.add(new Reservations(name, tableNumber, timeSlot));
        System.out.println("Table " + tableNumber + " reserved successfuly for " + name + " at " + timeSlot);
    }

    public void cancelReservation(int tableNumber, String timeSlot){
        Reservations toRemove = null;
        for(Reservations r : reservations){
            if(r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot)){
                toRemove = r;
                break;
            }
        }

        if(toRemove != null){
            reservations.remove(toRemove);
            System.out.println("Reservation for table " + tableNumber + " at " + timeSlot + " canceled.");
        }
        else
            System.out.println("No reservation found for Table " + tableNumber + " at " + timeSlot);
    }

    public void availableTables(String timeSlot){
        System.out.println("Available Tables for " + timeSlot + ": ");
        for(Table table : tables.values()){
            boolean reserved = false;
            for(Reservations r : reservations){
                if(r.getTableNumber() == table.getTableNumber() && r.getTimeSlot().equals(timeSlot)){
                    reserved = true;
                    break;
                }
            }
            if(!reserved)
                System.out.println(table);
        }
    }
}

public class RestaurantReservation{
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.addTable(new Table(1));
        restaurant.addTable(new Table(2));
        restaurant.addTable(new Table(3));
        restaurant.addTable(new Table(4));

        try{
            restaurant.reserveTable("Adam", 1, "5 PM");
            restaurant.reserveTable("Olive", 3, "8 PM");
            restaurant.reserveTable("Liam", 2, "5 PM");
            restaurant.reserveTable("Jack", 1, "5 PM");
        }
        catch(TableAlreadyReservedException e){
            System.out.println(e.getMessage());
        }

        System.out.println();
        restaurant.availableTables("5 PM");
        System.out.println();
        restaurant.cancelReservation(2, "7 PM");
        System.out.println();
        restaurant.availableTables("8 PM");
    }
}