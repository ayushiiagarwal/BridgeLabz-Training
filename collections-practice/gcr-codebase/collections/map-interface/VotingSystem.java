import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Adam", 130);
        votes.put("Liam", 140);
        votes.put("Olive", 180);

        LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>(votes);

        TreeMap<String, Integer> sorted = new TreeMap<>(votes);

        System.out.println("Votes (Input): " + orderedVotes);
        System.out.println("Votes (Sorted): " + sorted);
    }
}
