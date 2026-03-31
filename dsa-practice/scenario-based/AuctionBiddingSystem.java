import java.util.Map;
import java.util.TreeMap;

class InvalidBidException extends Exception{
    public InvalidBidException(String message){
        super(message);
    }
}

class User implements Comparable<User>{
    private String userId;
    private String name;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }

    public String getId(){ return userId; }
    
    public String getName(){ return name; }

    @Override
    public int compareTo(User other){
        return this.userId.compareTo(other.userId);
    }

    public String toString(){
        return "\nID: " + userId + "\nName: " + name;
    }
}

class Bid{
    private User user;
    private double amount;

    public Bid(User user, double amount){
        this.user = user;
        this.amount = amount;
    }

    public User getUser(){ return user; }

    public double getAmount(){ return amount; }

    @Override
    public String toString(){
        return user.getName() + " bid: " + amount;
    }    
}

class AuctionItem{
    private String itemName;
    private TreeMap<User, Double> bids;
    private double highestBid;

    public AuctionItem(String itemName){
        this.itemName = itemName;
        this.bids = new TreeMap<>();
        this.highestBid = 0.0;
    }

    public void placeBid(Bid bid) throws InvalidBidException{
        if(bid.getAmount() <= highestBid)
            throw new InvalidBidException("Bid must be higher than " + highestBid);

        bids.put(bid.getUser(), bid.getAmount());
        highestBid = bid.getAmount();

        System.out.println("Bid Placed by " + bid.getUser().getName() + "!");
    }

    public void showHighestBid(){
        if(bids.isEmpty()){
            System.out.println("No bids placed yet.");
            return;
        }

        User highestBidder = null;
        double max = 0;

        for (Map.Entry<User, Double> entry : bids.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                highestBidder = entry.getKey();
            }
        }

        System.out.println("\nHighest Bid: " + max);
        System.out.println("Bidder: " + highestBidder);
    }

    public void displayAllBids(){
        System.out.println("\nAll Bids for " + itemName + ": ");
        for(Map.Entry<User, Double> entry : bids.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}

public class AuctionBiddingSystem{
    public static void main(String[] args) {
        AuctionItem item = new AuctionItem("Textured Painting");

        User user1 = new User("U101", "Adam");
        User user2 = new User("U102", "Liam");
        User user3 = new User("U103", "Olive");

        try{
            item.placeBid(new Bid(user1, 80000));
            item.placeBid(new Bid(user2, 100000));
            item.placeBid(new Bid(user3, 150000));
        } catch(InvalidBidException e){
            System.out.println("Error: " + e.getMessage());
        }

        item.displayAllBids();
        item.showHighestBid();
    }
}