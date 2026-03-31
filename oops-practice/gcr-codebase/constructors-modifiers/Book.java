class Book{
    String title, author;
    double price;

    public Book(){
        title = "Love Hypothesis";
        author = "Ali Hazelwood";
        price = 2000.0;
    }

    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void display(){
        System.out.println("Book Name: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);        
    }
}