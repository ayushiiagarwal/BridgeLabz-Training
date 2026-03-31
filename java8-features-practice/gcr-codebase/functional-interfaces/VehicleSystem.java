interface Vehicle{
    void rent();
    void returnVehicle();
}

class Car implements Vehicle{
    @Override
    public void rent(){
        System.out.println("Rented Car!");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returned Vehicle!");
    }
}

class Bike implements Vehicle{
    @Override
    public void rent(){
        System.out.println("Rented Bike!");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returned Vehicle!");
    }
}

class Bus implements Vehicle{
    @Override
    public void rent(){
        System.out.println("Rented Bus!");
    }

    @Override
    public void returnVehicle(){
        System.out.println("Returned Vehicle!");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle cars = new Car();
        Vehicle bikes = new Bike();
        Vehicle buses = new Bus();

        cars.rent();
        cars.returnVehicle();
        System.out.println();

        bikes.rent();
        bikes.returnVehicle();
        System.out.println();

        buses.rent();
        buses.returnVehicle();
    }
}
