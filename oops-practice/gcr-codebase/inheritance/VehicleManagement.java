interface Refuelable {
    void refuel();
}

class Vehicle2 {
    protected String model;
    protected int maxSpeed;

    public Vehicle2(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}

class ElectricVehicle extends Vehicle2 {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging at a supercharger station.");
    }
}

class PetrolVehicle extends Vehicle2 implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with petrol.");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla", 180);
        PetrolVehicle honda = new PetrolVehicle("Amaze", 200);

        tesla.charge();
        honda.refuel();
    }
}
