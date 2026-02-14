import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InvalidRatingException extends Exception{
    public InvalidRatingException(String message){
        super(message);
    }
}

class Feedback{
    private Map<String, List<Integer>> feedbacks = new HashMap<>();

    public void addRating(String eventId, int rating) throws InvalidRatingException{
        if(rating < 1 || rating > 5)
            throw new InvalidRatingException("Rating must be between 1 and 5.");

        feedbacks.putIfAbsent(eventId, new ArrayList<>());
        feedbacks.get(eventId).add(rating);
    }

    public double calculateAverage(String eventId){
        List<Integer> ratings = feedbacks.get(eventId);

        if(ratings == null || ratings .isEmpty())
            return 0;

        int sum = 0;
        for(int r : ratings)
            sum += r;

        return (double) sum / ratings.size();
    }

    public void topRatedEvent(){
        String topEvent = null;
        double highestAverage = 0;

        for(String eventId : feedbacks.keySet()){
            double avg = calculateAverage(eventId);

            if(avg > highestAverage){
                highestAverage = avg;
                topEvent = eventId;
            }
        }

        if(topEvent != null)
            System.out.println("Top Rated Event: " + topEvent + "\nAverage Rating: " + highestAverage);
        else
            System.out.println("No events Availabke!");
    }

    public void displayAllAverage(){
        for(String eventId: feedbacks.keySet())
            System.out.println(eventId + " - Average Rating: " + calculateAverage(eventId));
    }
}

public class EventAnalyzer {
    public static void main(String[] args) {
        try{
            Feedback feedback = new Feedback();

            feedback.addRating("E101", 5);
            feedback.addRating("E102", 4);
            feedback.addRating("E103", 5);
            feedback.addRating("E104", 2);
            feedback.addRating("E105", 3);
            feedback.addRating("E106", 1);

            feedback.displayAllAverage();
            System.out.println();
            feedback.topRatedEvent();
        }
        catch(InvalidRatingException e){
            System.out.println(e.getMessage());
        }
    }
}
