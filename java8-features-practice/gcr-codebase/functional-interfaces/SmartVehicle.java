interface VehicleDashboard{
    void displaySpeed(int speed);

    default void displayBattery(int battery){
        System.out.println("No battery percentage for normal vehicles");
    }
}

class CarVehicle implements VehicleDashboard{
    public void displaySpeed(int speed){
        System.out.println("Speed: " + speed + "km/h");
    }
}

class BikeVehicle implements VehicleDashboard{
    public void displaySpeed(int speed){
        System.out.println("Speed: " + speed + "km/h");
    }
}

class ElectricVehicle implements VehicleDashboard{
    public void displaySpeed(int speed){
        System.out.println("Speed: " + speed + "km/h");
    }

    public void displayBattery(int battery){
        System.out.println("Battery: " + battery + "%");
    }
}

public class SmartVehicle {
    public static void main(String[] args) {
        VehicleDashboard car = new CarVehicle();
        VehicleDashboard bike = new BikeVehicle();
        VehicleDashboard electric = new ElectricVehicle();

        car.displaySpeed(80);
        bike.displaySpeed(60);
        bike.displayBattery(0);
        electric.displaySpeed(40);
        electric.displayBattery(70);
    }
}
