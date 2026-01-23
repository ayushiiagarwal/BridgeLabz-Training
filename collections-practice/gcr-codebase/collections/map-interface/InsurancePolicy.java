import java.time.LocalDate;
import java.util.*;

class Policy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;

    Policy(int policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return "Policy Number: " + policyNumber + "\nPolicy Holder's Name: " + holderName + "\nPolicy Exiry Date: " + expiryDate;
    }
}

public class InsurancePolicy {
    public static void main(String[] args) {
        Map<Integer, Policy> hashMap = new HashMap<>();

        
        Map<Integer, Policy> linkedMap = new LinkedHashMap<>();

        
        TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

        Policy p1 = new Policy(101, "Adam", LocalDate.now().plusDays(10));
        Policy p2 = new Policy(102, "Liam", LocalDate.now().plusDays(40));
        Policy p3 = new Policy(103, "Adam", LocalDate.now().minusDays(5));

        hashMap.put(101, p1);
        hashMap.put(102, p2);
        hashMap.put(103, p3);

        linkedMap.putAll(hashMap);

        treeMap.put(p1.expiryDate, p1);
        treeMap.put(p2.expiryDate, p2);
        treeMap.put(p3.expiryDate, p3);

        
        System.out.println(hashMap.get(101));

        System.out.println("--------------------------");
        System.out.println("\nExpiring within 30 days:");
        for (Policy p : hashMap.values()) {
            if (!p.expiryDate.isAfter(LocalDate.now().plusDays(30))) {
                System.out.println(p);
                System.out.println();
            }
        }

        System.out.println("--------------------------");
        System.out.println("\nPolicies for Adam:");
        for (Policy p : hashMap.values()) {
            if (p.holderName.equals("Adam")) {
                System.out.println(p);
            }
        }

        System.out.println("--------------------------");
        hashMap.values().removeIf(p -> p.expiryDate.isBefore(LocalDate.now()));
        System.out.println("\nAfter removing expired:");
        hashMap.values().forEach(System.out::println);
    }
}
