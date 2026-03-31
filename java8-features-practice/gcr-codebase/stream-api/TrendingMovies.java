import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Movie{
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear){
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle(){ return title; }
    public double getRating(){ return rating; }
    public int getYear(){ return releaseYear; }

    @Override
    public String toString(){
        return title + " (" + releaseYear + ") - " + rating;
    }
}

public class TrendingMovies{
    public static void main(String[] args) {
        List<Movie> movies = List.of(
            new Movie("A", 5.6, 2024),
            new Movie("B", 4.9, 2025),
            new Movie("C", 8.6, 2023),
            new Movie("D", 7.6, 2022),
            new Movie("E", 6.6, 2021),
            new Movie("F", 9.8, 2020),
            new Movie("G", 8.2, 2025)
        );

        List<Movie> top5 = movies.stream().filter(movie -> movie.getRating() >= 8)
                            .sorted(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getYear).reversed())
                            .limit(5).collect(Collectors.toList());

        top5.forEach(System.out::println);
    }
}