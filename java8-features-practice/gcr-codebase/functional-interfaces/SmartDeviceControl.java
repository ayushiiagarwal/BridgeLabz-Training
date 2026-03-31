interface SmartDevices{
    void turnOff();
    void turnOn();
}

class Lights implements SmartDevices{
    @Override
    public void turnOn(){
        System.out.println("Turning on Lights!");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off Lights!");
    }
}

class AC implements SmartDevices{
    @Override
    public void turnOn(){
        System.out.println("Turning on AC!");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off AC!");
    }
}

class TV implements SmartDevices{
    @Override
    public void turnOff(){
        System.out.println("Turning off TV!");
    }

    @Override
    public void turnOn(){
        System.out.println("Turning on TV!");
    }
}

public class SmartDeviceControl{
    public static void main(String[] args) {
        SmartDevices lights = new Lights();
        SmartDevices ac = new AC();
        SmartDevices tv = new TV();

        lights.turnOn();
        lights.turnOff();
        System.out.println();

        ac.turnOn();
        ac.turnOff();
        System.out.println();

        tv.turnOn();
        tv.turnOff();
        System.out.println();
    }
}