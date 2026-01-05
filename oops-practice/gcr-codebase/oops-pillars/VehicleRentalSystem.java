interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { 
        return vehicleNumber; 
    }
    public String getType() { 
        return type; 
    }
    public double getRentalRate() { 
        return rentalRate; 
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 5000; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy No. " + insurancePolicy;
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1500; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy No. " + insurancePolicy;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; 
    }

    @Override
    public double calculateInsurance() {
        return 8000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy No. " + insurancePolicy;
    }
}

public class VehicleRentalSystem {
    public static void processVehicles(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            double rental = v.calculateRentalCost(days);
            double insurance = 0;

            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
                System.out.println(((Insurable) v).getInsuranceDetails());
            }

            System.out.println("Vehicle: " + v.getType() + " | No: " + v.getVehicleNumber());
            System.out.println("Rental for " + days + " days: " + rental);
            System.out.println("Insurance: " + insurance);
            System.out.println("Total Cost: " + (rental + insurance));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("DL10AD1458", 2000, "CAR1544652"),
            new Bike("DL11CD4548", 1000, "BIKE232135"),
            new Truck("DL13BD4588", 5500, "TRUCK161554")
        };

        processVehicles(vehicles, 7); 
    }
}