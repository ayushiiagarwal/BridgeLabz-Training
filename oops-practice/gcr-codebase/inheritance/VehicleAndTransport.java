class Vehicle{
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo(){
        System.out.println("Maximum Speed: " + maxSpeed + "km/h, Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle{
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo(){
        System.out.println("Type: Car" + ", Seat Capacity: " + seatCapacity);
        super.displayInfo();
    }
}

class Truck extends Vehicle{
    double loadCapacity;

    public Truck(int maxSpeed, String fuelType, double loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo(){
        System.out.println("Type: Truck" + ", Load Capacity: " + loadCapacity + "kg");
        super.displayInfo();
    }
}

class Motorcycle extends Vehicle{
    boolean sideCar;

    public Motorcycle(int maxSpeed, String fuelType, boolean sideCar){
        super(maxSpeed, fuelType);
        this.sideCar = sideCar;
    }

    @Override
    public void displayInfo(){
        System.out.println("Type: Motorcycle" + ", Side Car: " + (sideCar ? "Yes" : "No"));
        super.displayInfo();
    }
}

public class VehicleAndTransport {
    public static void main(String[] args) {
        Vehicle car = new Car(120, "CNG", 5);
        Vehicle truck = new Truck(100, "Diesel", 15.0);
        Vehicle motor = new Motorcycle(150, "Petrol", false);

        car.displayInfo();
        System.out.println();
        truck.displayInfo();
        System.out.println();
        motor.displayInfo();
    }    
}
