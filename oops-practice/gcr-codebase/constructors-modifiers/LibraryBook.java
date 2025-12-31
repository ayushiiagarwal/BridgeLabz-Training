public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            System.out.println("You have successfully borrowed " + title);
            available = false;
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    public void display() {
        if(available)
        System.out.println("Book Available: " + title);

        else
            System.out.println("No book available anymore");
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Love on the Brain", "Ali Hazelwood", 2000.0, true);
        book.display();
        book.borrowBook();
        book.display();
    }
}
