class Movie{
    String title, director, year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, String year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagement {
    Movie head = null, tail = null;

    public void addAtBeginning(String title, String director, String year, double rating){
        Movie newMovie = new Movie(title, director, year, rating);
        if(head == null){
            head = tail = newMovie;
            return;
        }
        newMovie.next = head;
        head.prev = newMovie;
        head = newMovie;
    }

    public void addAtEnd(String title, String director, String year, double rating){
        if(head == null){
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        Movie newMovie = new Movie(title, director, year, rating);
        tail.next = newMovie;
        newMovie.prev = tail;
        tail = newMovie;
    }

    public void addAtPosition(int pos, String title, String director, String year, double rating){
        if(pos <= 1){
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for(int i=0; temp != null && i < pos-1; i++){
            temp = temp.next;
        }
        if(temp.next == null){
            addAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;

        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    public void removeMovie(String title){
        Movie temp = head;
        while(temp != null && temp.title.equals(title)){
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp == head)
            head = temp.next;
        if (temp == tail)
            tail = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    public void search(String director, double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println("Movie: " + temp.title + " | Dir: " + temp.director + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching records found.");
    }

    public void updateRating(String title, float newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("\nRating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        Movie temp = head;
        System.out.println("Forward Movie List:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        System.out.println("\nReverse Movie List:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagement movie = new MovieManagement();
        movie.addAtEnd("Inception", "Nolan", "2010", 9.0);
        movie.addAtBeginning("Jawan", "Atlee", "2023", 8.2f);
        movie.addAtPosition(2, "Dunki", "Hirani", "2023", 8.5f);
        movie.displayForward();
        movie.updateRating("Jawan", 9.1f);
        movie.removeMovie("Dunki");
        movie.displayReverse();
        movie.search("Nolan", 9.1f);
    }
}
