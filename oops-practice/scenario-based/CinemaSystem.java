import java.util.*;

class InvalidTimeFormatException extends Exception{
    InvalidTimeFormatException(String message){
        super(message);
    }
}

class CinemaTime{
    private List<String> titles = new ArrayList<>();
    private List<String> times = new ArrayList<>();

    void addMovie(String title, String time) throws InvalidTimeFormatException {
        if(!isValidTime(time)){
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        titles.add(title);
        times.add(time);
    }

    void searchMovie(String keyword){
        try{
            for(int i=0; i<titles.size(); i++){
                if(titles.get(i).contains(keyword)){
                    System.out.println(String.format("Found: %s at %s", titles.get(i), times.get(i)));
                }
            }
        } 
        catch(IndexOutOfBoundsException e){
            System.out.println("Invalid index accessed during search.");
        }
    }

    void displayAllMovies(){
        for(int i=0; i<titles.size(); i++) {
            System.out.println(
                String.format("Movie: %s | Time: %s", titles.get(i), times.get(i))
            );
        }
    }

    void generateReport(){
        String[] titleArray = titles.toArray(new String[0]);
        String[] timeArray = times.toArray(new String[0]);

        System.out.println("\nPrintable Report:");
        for(int i=0; i<titleArray.length; i++) {
            System.out.println(titleArray[i] + " - " + timeArray[i]);
        }
    }

    private boolean isValidTime(String time){
        try{
            String[] parts = time.split(":");
            int hh = Integer.parseInt(parts[0]);
            int mm = Integer.parseInt(parts[1]);
            return hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59;
        } 
        catch(Exception e){
            return false;
        }
    }
}

public class CinemaSystem {
    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try{
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("The Adam Project", "21:00");
            cinema.addMovie("Avatar", "25:99");  
        } 
        catch(InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Movies:");
        cinema.displayAllMovies();

        System.out.println("\nSearch Result:");
        cinema.searchMovie("Inter");

        cinema.generateReport();
    }
}
