class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    Ticket(int id, String name, String movie, String seat, String time) {
        this.ticketID = id;
        this.customerName = name;
        this.movieName = movie;
        this.seatNumber = seat;
        this.bookingTime = time;
    }
}

public class OnlineTicket {
    Ticket head = null;
    Ticket tail = null;

    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head; 
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; 
        }
    }

    public void removeTicket(int id) {
        System.out.println("Removing Ticket: " + id);
        if (head == null) return;

        Ticket curr = head, prev = tail;
        do {
            if (curr.ticketID == id) {
                if (curr == head && curr == tail) { 
                    head = tail = null;
                }
                else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println(temp.ticketID + ": " + temp.customerName + " - " + temp.movieName);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String search) {
        System.out.println("Searching for Movie: " + search);
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(search) || temp.movieName.equalsIgnoreCase(search)) {
                System.out.println("Found: Ticket " + temp.ticketID + " for " + temp.customerName + " (Movie: " + temp.movieName + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching records found.");
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        OnlineTicket system = new OnlineTicket();

        system.addTicket(101, "Adam", "Inception", "A1", "10:00 PM");
        system.addTicket(102, "Olive", "The Life List", "A2", "10:00 PM");
        system.addTicket(103, "Liam", "Love at First Sight", "A3", "10:00 PM");

        System.out.println("Current Bookings:");
        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());
        System.out.println();

        system.searchTicket("Inception");
        System.out.println();

        system.removeTicket(102);
        System.out.println();
        
        System.out.println("Final List:");
        system.displayTickets();
    }
}