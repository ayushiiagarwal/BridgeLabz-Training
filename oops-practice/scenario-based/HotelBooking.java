class RoomNotAvailableException extends Exception{
    public RoomNotAvailableException(String message){
        super(message);
    }
}

interface PricingStrategy{
    double calculatePrice(double price);
}

class NormalPricing implements PricingStrategy{
    public double calculatePrice(double price){
        return price;
    }
}

class SeasonalPricing implements PricingStrategy{
    public double calculatePrice(double price){
        return price * 1.5;
    }
}

class Guest{
    private String name;

    public Guest(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Room{
    private int roomNumber;
    private double price;
    private boolean isAvailable = true;

    public Room(int roomNumber, double price){
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public void checkIn() throws RoomNotAvailableException{
        if(!isAvailable){
            throw new RoomNotAvailableException("Room Not Available");
        }
        isAvailable = false;
    }

    public void checkOut(){
        isAvailable = true;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public double getPrice(PricingStrategy strategy){
        return strategy.calculatePrice(price);
    }
}

class StandardRoom extends Room{
    public StandardRoom(int roomNumber){
        super(roomNumber, 2000);
    }
}

class DeluxeRoom extends Room{
    public DeluxeRoom(int roomNumber){
        super(roomNumber, 5000);
    }
}

class Reservation{
    private Guest guest;
    private Room room;
    private double bill;

    public Reservation(Guest guest, Room room, PricingStrategy strategy) throws RoomNotAvailableException{
        this.guest = guest;
        this.room = room;
        room.checkIn();
        bill = room.getPrice(strategy);
    }

    public void checkOut(){
        room.checkOut();
    }

    public void generateInvoice(){
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.getRoomNumber());
        System.out.println("Amount: " + bill);
    }
}


public class HotelBooking {
    public static void main(String[] args) {
        Room room1 = new StandardRoom(1001);
        Room room2 = new DeluxeRoom(5001);

        Guest guest1 = new Guest("Adam");
        Guest guest2 = new Guest("Liam");

        PricingStrategy seasonal = new SeasonalPricing();
        PricingStrategy normal = new NormalPricing();

        try{
            Reservation booking = new Reservation(guest1, room1, seasonal);
            booking.generateInvoice();
            booking.checkOut();
            System.out.println();

            Reservation booking2 = new Reservation(guest2, room2, normal);
            booking2.generateInvoice();
            booking2.checkOut();
        }
        catch(RoomNotAvailableException e){
            System.out.println(e.getMessage());
        }
    }
}
