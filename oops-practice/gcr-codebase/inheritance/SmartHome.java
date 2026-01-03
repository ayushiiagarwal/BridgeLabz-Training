class Device{
    int deviceID;
    String status;

    public Device(int deviceID, String status){
        this.deviceID = deviceID;
        this.status = status;
    }
}

class Thermostat extends Device{
    int temperatureSetting;

    Thermostat(int deviceID, String status, int temperatureSetting){
        super(deviceID, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus(){
        System.out.println("Device ID: " + deviceID);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat(101, "Active", 24);
        thermostat.displayStatus();
    }
}
