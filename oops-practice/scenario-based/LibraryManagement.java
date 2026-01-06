import java.util.*;

class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}
class Book{
    private String title, author;
    private boolean isAvailable;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle(){
        return title;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setStatus(boolean available){
        isAvailable = available;
    }

    @Override
    public String toString(){
        String status = isAvailable ? "Available" : "Not Available";
        return String.format("%-20s | %-15s | %s", title, author, status);
    }
}

public class LibraryManagement {
    private List<Book> bookList;

    public LibraryManagement(Book[] books) {
        this.bookList = new ArrayList<>(Arrays.asList(books));
    }

    public void searchByTitle(String searchTitle) {
        System.out.println("\nSearching for: " + searchTitle);
        System.out.printf("%-20s | %-15s | %s", "Title", "Author", "Status\n\n");

        boolean found = false;
        for (Book b : bookList) {
            if (b.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No book found.");
    }

    public void checkOut(String exactTitle) throws BookNotAvailableException {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(exactTitle)) {
                if (!b.isAvailable()) {
                    throw new BookNotAvailableException("The book '" + exactTitle + "' is already checked out.");
                }
                b.setStatus(false);
                System.out.println("\nChecked out: " + exactTitle);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayLibrary() {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        Book[] inventory = {
            new Book("Throttled", "Lauren Asher"),
            new Book("To Hate Adam Connor", "Ella Maise"),
            new Book("The Great Gatsby", "F. Scott Fitzgerald")
        };

        LibraryManagement library = new LibraryManagement(inventory);

        library.searchByTitle("Throt");
        try {
            library.checkOut("Throttled");
            library.checkOut("The Great Gatsby"); 
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.printf("%-20s | %-15s | %s", "Title", "Author", "Status\n");
        library.displayLibrary();
    }
}
