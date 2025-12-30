public class MovieTicket {
    String movieName, seatNumber;
    double price;
    boolean isBooked = false;

    MovieTicket(){
        this.movieName = "";
        this.seatNumber = "";
        this.price = 0.0;

    }

    public void display(){
        if(!isBooked){
            System.out.println("Ticket have not booked yet...");
        }
        
        else{
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public void bookTicket(String movie, String seat, double cost){
        if(!isBooked){
            this.movieName = movie;
            this.seatNumber = seat;
            this.price = cost;
            this.isBooked = true;
            System.out.println("Ticket Booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        }
        else{
            System.out.println("House full!!! Sorry....Ticket already booked");
            System.out.println("House full!!! Sorry....Ticket already booked");
        }
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        
        ticket.display();

        ticket.bookTicket("Dragon", "A10", 120.0);

        ticket.bookTicket("Dragon", "A10", 120.0);
        
        ticket.display();
    }
}
