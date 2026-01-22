import java.util.*;
public class FindSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of Set 1: ");
        int s1 = sc.nextInt();

        System.out.print("Size of Set 2: ");
        int s2 = sc.nextInt();

        System.out.print("Set 1 Elements: ");
        Set<Integer> set1 = new HashSet<>();
        for(int i=0;i<s1;i++)
            set1.add(sc.nextInt());

        System.out.print("Set 2 Elements: ");
        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<s2;i++)
            set2.add(sc.nextInt());

        sc.close();
        System.out.println("Set 1: " + set1 + "\nSet 2: " + set2);

        if(set2.containsAll(set1) || set1.containsAll(set2))
            System.out.println("True.");
        else
            System.out.println("False.");
    }
}
