public class Vehicle {
    String ownerName, vehicleType;
    static double registrationFee;

    Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void updateRegistrationFee(double fee){
        
    }

    void displayVehicleDetails(){
        System.out.println("Owner name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " );
    }
        
    public static void main(String[] args) {
       Vehicle type1 = new Vehicle("Aysuhi", "Bike");
       Vehicle type2 = new Vehicle("Alankrati", "Car");

       type1.displayVehicleDetails();
       type2.displayVehicleDetails();
    }
}
