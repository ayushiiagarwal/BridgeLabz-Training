class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, int bookID) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = true; 
    }
}

public class LibraryManagement {
    Book head = null, tail = null;
    int count = 0;
    
    public void addAtBeginning(String title, String author, String genre, int id) {
        Book newBook = new Book(title, author, genre, id);
        if (head == null) {
            head = tail = newBook;
        }
        else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addAtEnd(String title, String author, String genre, int id) {
        if (head == null) {
            addAtBeginning(title, author, genre, id);
            return;
        }
        Book newBook = new Book(title, author, genre, id);
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
        count++;
    }

    public void addAtPosition(int pos, String title, String author, String genre, int id) {
        if (pos <= 1) { 
            addAtBeginning(title, author, genre, id); 
            return; 
        }
        if (pos > count) { 
            addAtEnd(title, author, genre, id); 
            return; 
        }

        Book temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        Book newBook = new Book(title, author, genre, id);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    public void removeBook(int id) {
        if (head == null) return;
        Book curr = head;

        while (curr != null && curr.bookID != id) curr = curr.next;

        if (curr == null) { 
            System.out.println("Book not found."); 
            return; 
        }

        if (curr == head) {
            head = head.next;
            if (head != null) 
                head.prev = null;
        }
        else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        count--;
    }

    public void searchByTitleOrAuthor(String search) {
        Book curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(search) || curr.author.equalsIgnoreCase(search)) {
                System.out.println("Found: " + curr.title + " by " + curr.author);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    public void updateStatus(int id, boolean status) {
        Book curr = head;
        while (curr != null) {
            if (curr.bookID == id) {
                curr.isAvailable = status;
                return;
            }
            curr = curr.next;
        }
    }

    public void displayForward() {
        Book curr = head;
        while (curr != null) {
            System.out.print(curr.title + " " + curr.bookID + " \n");
            curr = curr.next;
        }
    }

    public void displayReverse() {
        Book curr = tail;
        while (curr != null) {
            System.out.print(curr.title + " " + curr.bookID + " \n");
            curr = curr.prev;
        }
    }
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtBeginning("Verity", "John Smith", "Thriller",101);
        library.addAtEnd("Harry Potter", "J. K. Rowling", "Fiction", 102);
        library.addAtEnd("Percy Jackson", "J. K. Rowling", "Fiction", 103);

        System.out.println("Forward List:");
        library.displayForward();

        System.out.println("\nReverse List:");
        library.displayReverse();

        System.out.println("\nRemoving ID 102\n" );
        library.removeBook(102);
        
        System.out.println("Final List:");
        library.displayForward();
    }    
}
