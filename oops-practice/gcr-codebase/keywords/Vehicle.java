public class Vehicle {
    private static double registrationFee = 150.0;
    private String ownerName, vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayVehicleDetails(){
        if(this instanceof Vehicle){
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registraton Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void updateRegistrationFee(double newFee){
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle type1 = new Vehicle("Honest Raj", "Sedan", "ABC123");
        Vehicle type2 = new Vehicle("Price Danish", "SUV", "XYZ789");

        type1.displayVehicleDetails();
        System.out.println();
        type2.displayVehicleDetails();
    }
}
