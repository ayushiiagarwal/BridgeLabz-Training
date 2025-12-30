public class BookDetails {

    String title;
    String author;
    double price;

    BookDetails(String title, String author, Double price){
        this.title = title;
        this.author = author;
        this.price = price;

    }

    public void displayDetails(){
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
    public static void main(String[] args) {
        BookDetails book1 = new BookDetails("2States", "Chetan Bhagat", 500.0);
        BookDetails book2 = new BookDetails("Wings Of Fire", "Abdul Kalam A.P.J", 500.0);

        book1.displayDetails();
        System.out.println();
        book2.displayDetails();
    }
}
