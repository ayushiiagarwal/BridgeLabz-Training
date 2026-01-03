import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean status;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.status = true;
    }
}

public class LibraryManagement {

    public static int searchBook(Book[] library, String searchTtile){
        for(int i=0;i<library.length;i++){
            if(library[i].title.toLowerCase().contains(searchTtile.toLowerCase()))
                return i;
        }
        return -1;
    }

    public static void displayStatus(Book book){
        String status = book.status ? "Available" : "Not Available";
        System.out.println("Current Status: " + status);
    }

    public static void updateStatus(Book book){
        book.status = !book.status;
        System.out.println("Status updated!");
        displayStatus(book);
    }

    public static void main(String[] args) {

        Book[] library = {
            new Book("Throttled", "Lauren Asher"),
            new Book("Love Hypothesis", "Ali Hazelwood"),
            new Book("Harry Potter", "J. k. Rowling"),
            new Book("Twisted Love", "Ana Haung")
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book title to search: ");
        String searchTitle = sc.nextLine();

        int bookIndex = searchBook(library, searchTitle);

        if(bookIndex != -1){
            System.out.println("Book Found: " + library[bookIndex].title + " by " + library[bookIndex].author);
            displayStatus(library[bookIndex]);

            System.out.println("Would you like to checkout?(Yes/No): ");
            if(sc.nextLine().equalsIgnoreCase("yes"))
                updateStatus(library[bookIndex]);
        }
        else{
            System.out.println("No book found");
        }

        sc.close();

    }
}
