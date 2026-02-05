import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book{
    private String genre;
    private int pages;

    public Book(String genre, int pages){
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre(){ return genre; }
    public int getPages(){ return pages; }
}

public class LibraryBook {
    public static void main(String[] args) {
        List<Book> books = List.of(
            new Book("Fiction", 350),
            new Book( "Thriller", 250),
            new Book("Fiction", 400),
            new Book("Thriller", 600)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
                        .collect(
                            Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages))
                        );
        
        stats.forEach((genre, stat) -> System.out.println(
            "\nGenre: " + genre + 
            "\nTotal Pages: " + stat.getSum() +
            "\nAverage Pages: " + stat.getAverage() +
            "\nMax Pages: " + stat.getMax()
        ));
    }
}
