import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Adam", 130);
        votes.put("Liam", 140);
        votes.put("Olive", 180);

        LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>();
        orderedVotes.put("Adam", 130);
        orderedVotes.put("Liam", 140);
        orderedVotes.put("Olive", 180);

        TreeMap<Integer, String> sorted = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Votes (Input): " + orderedVotes);
        System.out.println("Votes (Sorted): " + sorted);
    }
}
