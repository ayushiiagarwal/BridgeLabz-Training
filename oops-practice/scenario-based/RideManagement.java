import java.util.*;

class NoDriverAvailableException extends Exception{
    public NoDriverAvailableException(String message){
        super(message);
    }
}

class User{
    private String userName;
    
    public User(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }
}

class Driver{
    private String driverName;
    private boolean isAvailable;
    
    public Driver(String driverName){
        this.driverName = driverName;
        this.isAvailable = true;
    }

    public String getDriverName(){
        return driverName;
    }

    public boolean getStatus(){
        return isAvailable;
    }

    public void setStatus(boolean available){
        isAvailable = available;
    }
}

class Ride{
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, FareCalculator fare){
        this.user = user;
        this.driver=driver;
        this.distance = distance;
        this.fare = fare.calculate(distance);
        this.driver.setStatus(false);
    }

    @Override
    public String toString(){
        return "User: " + user.getUserName() + "\nDriver: " + driver.getDriverName() + "\nDistance: " + distance + "\nFare: " + fare + "\n";
    }
}

interface FareCalculator{
    double calculate(double distance);
}

class NormalPricing implements FareCalculator{
    public double calculate(double distance){
        return distance * 20.0;
    }
}

class PeakPricing implements FareCalculator{
    public double calculate(double distance){
        return distance * 50.0;
    }
}

public class RideManagement {
    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();

    public void addDriver(Driver d){
        drivers.add(d);
    }

    public void bookRide(User user, double distance, boolean isPeakHour) throws NoDriverAvailableException{
        Driver assignedDriver = null;

        for(Driver d : drivers){
            if(d.getStatus()){
                assignedDriver = d;
                break;
            }
        }

        if(assignedDriver == null)
            throw new NoDriverAvailableException("No more Drivers currently available.\n");

        FareCalculator fare = isPeakHour ? new PeakPricing() : new NormalPricing();

        Ride ride = new Ride(user, assignedDriver, distance, fare);
        rides.add(ride);
        System.out.println("Rides Booked\n" + ride);
    }

    public void showHistory(){
        System.out.println("Ride History");
        for(Ride r : rides)
            System.out.println(r);
    }
    public static void main(String[] args) {
        RideManagement cab = new RideManagement();
        cab.addDriver(new Driver("Steve"));
        cab.addDriver(new Driver("Olive"));

        User customer = new User("Adam");

        try{
            cab.bookRide(customer, 10, false);
            cab.bookRide(new User("Sam"), 15, true);
            cab.bookRide(new User("Monica"), 25, false);
        }
        catch(NoDriverAvailableException e){
            System.out.println(e.getMessage());
        }

        cab.showHistory();
    }
}
