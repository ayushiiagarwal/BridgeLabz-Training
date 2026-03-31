import java.util.Scanner;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter movie type (1: Regular, 2: 3D): ");
            int movieType = sc.nextInt();

            System.out.println("Enter seat type (1: Gold, 2: Silver): ");
            int seatType = sc.nextInt();

            System.out.println("Do you want snacks? (yes/no): ");
            String wantsSnacks = sc.next();

            double ticketPrice = 0.0;

            switch (movieType) {
                case 1: 
                    ticketPrice += 100.0;
                    break;
                case 2: 
                    ticketPrice += 200.0;
                    break;
                default:
                    System.out.println("Invalid movie type selected.");
                    continue;
            }

            if (seatType == 1) { 
                ticketPrice += 50.0;
            } else if (seatType == 2) { 
                ticketPrice += 150.0;
            } else {
                System.out.println("Invalid seat type selected.");
                continue;
            }

            if (wantsSnacks.equalsIgnoreCase("yes")) {
                ticketPrice += 100.0; 
            }

            System.out.println("Total ticket price: Rs. " + ticketPrice);

            System.out.println("Next customer? (yes/no): ");
            String response = sc.next();

            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }
        sc.close();
    }
}
