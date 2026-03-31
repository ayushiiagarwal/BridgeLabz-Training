class BookModifiers {
    public String ISBN;
    protected String title;
    private String author;

    BookModifiers(String ISBN, String title, String author){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

class EBook extends BookModifiers{
    public EBook(String ISBN, String title, String author){
        super(ISBN, title, author);
    }

    void bookDetails(){
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("789-4587469", "Love Hypothesis", "Ali Hazelwood");
        ebook.bookDetails();
    }
}
