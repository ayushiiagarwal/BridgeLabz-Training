class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo(){
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book{
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio){
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo(){
        System.out.println("Author's Name: " + name);
        System.out.println("Bio: " + bio);
        super.displayInfo();
    }

}

public class LibraryManagement {
    public static void main(String[] args) {
        Book author = new Author("Under One Roof", 2002, "Ali Hazelwood", "Writer");

        author.displayInfo();
    }
}
