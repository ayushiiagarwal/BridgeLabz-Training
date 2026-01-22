import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionIntersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size of set1: ");
        int n1 = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();

        System.out.print("Set1 Elements: ");
        for(int i=0;i<n1;i++)
            set1.add(sc.nextInt());

        Set<Integer> set2 = new HashSet<>();

        System.out.print("size of set2: ");
        int n2 = sc.nextInt();

        System.out.print("Set2 Elements: ");
        for(int i=0;i<n2;i++)
            set2.add(sc.nextInt());

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
    }
}
