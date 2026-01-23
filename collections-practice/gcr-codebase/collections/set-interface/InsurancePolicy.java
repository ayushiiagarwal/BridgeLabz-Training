import java.util.*;
import java.time.LocalDate;

class Policy implements Comparable<Policy>{
    int policyNumber;
    String holderName;
    LocalDate expirydate;
    String coverageType;
    double amount;

    Policy(int policyNumber, String holderName, LocalDate expiryDate, String coverageType, double amount){
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expirydate = expiryDate;
        this.coverageType = coverageType;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj){
        Policy p = (Policy) obj;
        return this.policyNumber == p.policyNumber;
    }

    @Override
    public int hashCode(){
        return policyNumber;
    }

    @Override
    public int compareTo(Policy p){
        return this.expirydate.compareTo(p.expirydate);
    }

    @Override
    public String toString(){
        return "\nPolicy Number: " + policyNumber + " | Policy Holder Name: " + holderName + 
        "\nExpiry Date: " + expirydate + " | Coverage Type: " + coverageType + "\nPremium Amount: " + amount;
    }
}

public class InsurancePolicy {

    static void display(Set<Policy> set){
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    static void expiringSoon(Set<Policy> set){
        LocalDate today = LocalDate.now();
        for (Policy p : set) {
            if(!p.expirydate.isAfter(today.plusDays(30)))
                System.out.println(p);
        }
    }

    static void coverageType(Set<Policy> set, String type){
        for (Policy p : set) {
            if(p.coverageType.equalsIgnoreCase(type))
                System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        Policy p1 = new Policy(101, "Adam", LocalDate.now().plusDays(20), "Health", 5000);
        Policy p2 = new Policy(102, "Liam", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy(103, "Charlie", LocalDate.now().plusDays(10), "Health", 4500);
        Policy p4 = new Policy(104, "Olive", LocalDate.now().plusDays(20), "Health", 5000);

        Collections.addAll(hashSet, p1, p2, p3, p4);
        Collections.addAll(linkedHashSet, p1, p2, p3, p4);
        Collections.addAll(treeSet, p1, p2, p3, p4);

        System.out.println("All Policies (HashSet): ");
        display(hashSet);

        System.out.println("------------------------");
        System.out.print("\nInsertion Order (LinkedHashSet): ");
        display(linkedHashSet);

        System.out.println("------------------------");
        System.out.print("\nSorted by Expiry Date (TreeSet): ");
        display(treeSet);
        
        System.out.println("------------------------");
        System.out.print("\nPolicies Expiring Within 30 Days: ");
        expiringSoon(hashSet);

        System.out.println("------------------------");
        System.out.print("\nPolicies with Health Coverage: ");
        coverageType(hashSet, "Health");
    }    
}
