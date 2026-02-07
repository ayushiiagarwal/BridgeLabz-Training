public class LibraryApp {
    public static void main(String[] args) {
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Adam");
        User faculty = UserFactory.createUser("faculty", "Dr. Liam");
        User librarian = UserFactory.createUser("librarian", "Olive");
        
        student.showRole();
        faculty.showRole();
        librarian.showRole();

        System.out.println();

        catalog.addObserver(student);
        catalog.addObserver(faculty);
        catalog.addObserver(librarian);

        Book book1 = new Book.BookBuilder("Design Patterns")
                             .author("GoF")
                             .genre("Software Engineering")
                             .build();

        catalog.addBook(book1);
    }
}
