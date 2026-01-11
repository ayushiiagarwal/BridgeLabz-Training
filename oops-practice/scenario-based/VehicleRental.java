import java.util.*;

interface IRentable{
    double calculateRent(int days);
}

abstract class Vehicle{
    protected String id;
    protected String model;
    protected double rate;

    public Vehicle(String id, String model, double rate){
        this.id = id;
        this.model = model;
        this.rate = rate;
    }

    public abstract void displayDetails();
}

class Customer{
    private String name; 
    private String customerId;

    public Customer(String name, String customerId){
        this.name = name;
        this.customerId = customerId;
    }

    public void rentVehicle(Vehicle v, int days){
        if(v instanceof IRentable){
            double cost = ((IRentable) v).calculateRent(days);
            System.out.println("Customer ID: " + customerId);
            System.out.println("Customer " + name + " rented " + v.model + " for " + days + " days. \nTotal: " + cost);
        }
    }
}

class Bike extends Vehicle implements IRentable{
    public Bike(String id, String model, double rate){
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days){
        return rate * days;
    }

    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Rental Rate Per Day: " + rate);
    }
}

class Car extends Vehicle implements IRentable{
    public Car(String id, String model, double rate){
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days){
        return (rate * days) + 30.0;
    }

    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Rental Rate Per Day: " + rate);
    }
}

class Truck extends Vehicle implements IRentable{
    public Truck(String id, String model, double rate){
        super(id, model, rate);
    }

    @Override
    public double calculateRent(int days){
        return (rate * days) + 50.0;
    }

    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Rental Rate Per Day: " + rate);
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bike("B001", "Harley Davidson", 5000.0));
        vehicles.add(new Car("C002", "Tesla", 4000.0));
        vehicles.add(new Truck("T003", "Ford", 3000.0));

        for(Vehicle v : vehicles){
            v.displayDetails();
            System.out.println();
        }
        
        Customer customer1 = new Customer("Alice Smith", "CA1");
        Customer customer2 = new Customer("John Smith", "CA2");

        customer1.rentVehicle(vehicles.get(1), 3);
        System.out.println();
        customer2.rentVehicle(vehicles.get(2), 2);
    }
}
