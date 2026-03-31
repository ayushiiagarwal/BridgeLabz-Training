public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        this.guestName = "Ayushi";
        this.roomType = "Standard";
        this.nights = 3;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest: " + guestName + "\nRoom: " + roomType + "\nNights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        booking.display();
    }
}
