import java.util.ArrayList;
import java.util.List;

class DuplicateVoteException extends Exception{
    public DuplicateVoteException(String message){
        super(message);
    } 
}

class Voter{
    private String name;
    private String voterId;
    private boolean hasVoted;

    public Voter(String name, String voterId, boolean hasVoted){
        this.name = name;
        this.voterId = voterId;
        this.hasVoted = false;
    }

    public String getName(){
        return name;
    }

    public String getVoterId(){
        return voterId;
    }

    public boolean getVote(){
        return hasVoted;
    }

    public void setVote(boolean status){
        this.hasVoted = status;
    }
}

class Candidate{
    private String candidateName;
    private int voteCount;

    public Candidate(String candidateName) {
        this.candidateName = candidateName;
        this.voteCount = 0;
    }

    public String getCandidateName() { 
        return candidateName; 
    }
    public int getVoteCount() { 
        return voteCount; 
    }
    
    public void incrementVote() {
        this.voteCount++;
    }
}

abstract class ElectionService {
    protected List<Candidate> candidates = new ArrayList<>();

    public abstract void castVote(Voter voter, String candidateName) throws DuplicateVoteException;
    
    public void addCandidate(Candidate c){
        candidates.add(c);
    }

    public void declareResults() {
        System.out.println("\n--- Election Results ---");
        for (Candidate c : candidates) {
            System.out.println(c.getCandidateName() + ": " + c.getVoteCount() + " votes");
        }
    }
}

class GeneralElection extends ElectionService {
    
    @Override
    public void castVote(Voter voter, String candidateName) throws DuplicateVoteException {
        if (voter.getVote()) {
            throw new DuplicateVoteException("Voter " + voter.getName() + " has already cast a vote!");
        }

        boolean found = false;
        for (Candidate c : candidates) {
            if (c.getCandidateName().equalsIgnoreCase(candidateName)) {
                c.incrementVote();
                voter.setVote(true);
                System.out.println("Success: " + voter.getName() + " voted for " + candidateName);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Candidate not found.");
        }
    }
}

public class OnlineVoting {
    public static void main(String[] args) {
        ElectionService election = new GeneralElection();
        election.addCandidate(new Candidate("Adam"));
        election.addCandidate(new Candidate("Olive"));

        Voter v1 = new Voter("Nick Jonal", "V101", true);
        Voter v2 = new Voter("Jack Smith", "V102", false);

        try {
            election.castVote(v1, "Adam");
            election.castVote(v2, "Olive");

            System.out.println("\nAttempting duplicate vote...");
            election.castVote(v1, "Bob"); 

        } catch (DuplicateVoteException e) {
            System.err.println(e.getMessage());
        }

        election.declareResults();
    }
}
