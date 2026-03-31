interface Reservable{
    boolean reserveItems();
    boolean checkAvailability();
}

abstract class LibraryItem{
    private String itemID, title, author;

    public LibraryItem(String itemID, String title, String author){
        this.itemID = itemID;
        this.title = title;
        this.author = author;
    }

    public void getItemDetails(){
        System.out.println("Item ID: " + itemID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable{
    public Book(String itemID, String title, String author){
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration(){
        return 7;
    }

    public boolean reserveItems(){
        return true;
    }

    public boolean checkAvailability(){
        return true;
    }
}

class Magazine extends LibraryItem implements Reservable{
    public Magazine(String itemID, String title, String author){
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration(){
        return 7;
    }

    public boolean reserveItems(){
        return true;
    }

    public boolean checkAvailability(){
        return true;
    }
}

class DVD extends LibraryItem implements Reservable{
    public DVD(String itemID, String title, String author){
        super(itemID, title, author);
    }

    @Override
    public int getLoanDuration(){
        return 7;
    }

    public boolean reserveItems(){
        return true;
    }

    public boolean checkAvailability(){
        return false;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B01", "1984", "George Orwell"),
            new Magazine("M01", "Forbes", "Steve"),
            new DVD("D01", "Inception", "Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration (days): " + item.getLoanDuration());
            if (item instanceof Reservable) {
                System.out.println(((Reservable) item).checkAvailability() ? "Available" : "Not Available");
            }
            System.out.println();
        }
    }
}
