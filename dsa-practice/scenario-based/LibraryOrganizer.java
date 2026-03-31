import java.util.*;

class Book{
    String title, author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }

    void display(){
        System.out.println(title + " by " + author);
    }
}

class BookShelf{
    private Map<String, LinkedList<Book>> list = new HashMap<>();
    private Set<Book> books = new HashSet<>();

    void addBook(String genre, Book book){
        if(books.contains(book)){
            System.out.println("Duplicate Book Ignored, " + book.title);
            return;
        }

        list.putIfAbsent(genre, new LinkedList<>());
        list.get(genre).add(book);
        books.add(book);

        System.out.println("Book added to: " + genre + ", " + book.title);
    }

    void borrowBook(String genre, Book book){
        if(!list.containsKey(genre) || !list.get(genre).remove(book)){
            System.out.println(book.title + ", Book not found!");
            return;
        }
        
        books.remove(book);
        System.out.println(book.title + ", Book Borrowed!");
    }

    void displayBooks(){
        for(String genre : list.keySet()){
            System.out.println("\nGenre: " + genre);
            for(Book book : list.get(genre))
                book.display();
        }
    }
}

public class LibraryOrganizer {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        Book b1= new Book("The Love Hypothesis", "Ali Hazelwood");
        Book b2 = new Book("Harry Potter", "J.K. Rowling");
        Book b3 = new Book("She Didn't See It Coming", "Shari Lapena");

        shelf.addBook("Romance", b1);
        shelf.addBook("Fiction", b2);
        shelf.addBook("Thriller", b3);

        shelf.addBook("Fiction", b1);

        System.out.println("\nLibrary List: ");
        shelf.displayBooks();

        shelf.borrowBook("Fiction", b2);

        System.out.println("\nAfter Borrowing: ");
        shelf.displayBooks();
    }
}
