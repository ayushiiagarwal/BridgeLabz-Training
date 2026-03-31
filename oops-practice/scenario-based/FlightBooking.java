import java.util.*;

class Flight {
    private String flightNumber;
    private String destination;
    private double price;

    public Flight(String flightNumber, String destination, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightNumber() { 
        return flightNumber; 
    }
    public String getDestination() { 
        return destination; 
    }
    public double getPrice() { 
        return price; 
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | $%.2f", flightNumber, destination, price);
    }
}

class Booking {
    private String passengerName;
    private Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void displayBookingDetails() {
        System.out.println("Passenger: " + passengerName + "\nFlight: " + flight.getFlightNumber() + 
                           " to " + flight.getDestination());
    }
}

public class FlightBooking {
    private static Flight[] availableFlights = {
        new Flight("AI-101", "New York", 550.0),
        new Flight("EK-202", "Dubai", 450.0),
        new Flight("LH-303", "London", 600.0),
        new Flight("SQ-404", "Singapore", 700.0)
    };

    private static List<Booking> userBookings = new ArrayList<>();

    public static void main(String[] args) {

        searchFlight("london");
        searchFlight("NEW YORK");

        bookFlight("John Doe", "AI-101");
        bookFlight("Jane Smith", "LH-303");

        showAllBookings();
    }

    public static void searchFlight(String dest) {
        System.out.println("Searching for flights to: " + dest);
        boolean found = false;
        for (Flight f : availableFlights) {
            if (f.getDestination().equalsIgnoreCase(dest)) {
                System.out.println("Match Found: " + f);
                found = true;
            }
        }
        if (!found) System.out.println("No flights found to " + dest);
    }

    public static void bookFlight(String passenger, String flightNum) {
        for (Flight f : availableFlights) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNum)) {
                Booking newBooking = new Booking(passenger, f);
                userBookings.add(newBooking);
                System.out.println("Successfully booked flight " + flightNum + " for " + passenger);
                return;
            }
        }
        System.out.println("Flight " + flightNum + " not found.");
    }

    public static void showAllBookings() {
        System.out.println("\n--- Current User Bookings ---");
        if (userBookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : userBookings) {
                b.displayBookingDetails();
            }
        }
    }
}
