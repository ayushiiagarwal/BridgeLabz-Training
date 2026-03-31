public class Book {
    private static String libraryName = "Egmore Library";
    private String title, author;
    private final String isbn;

    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    

    public static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails(){
        if(this instanceof Book){
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
        else
            System.out.println("No such book available");
    }

    public static void main(String[] args) {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        displayLibraryName();
        book1.displayBookDetails();
    }

}
