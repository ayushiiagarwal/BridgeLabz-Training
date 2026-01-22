import java.util.*;

public class CompareSets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("size of sets: ");
        int n = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.println("Set1 Elements: ");
        for(int i=0;i<n;i++)
            set1.add(sc.nextInt());

        System.out.println("Set2 Elements: ");
        for(int i=0;i<n;i++)
            set2.add(sc.nextInt());

        boolean result = false;

        if(set1.containsAll(set2)){
            result = true;
            System.out.println(result);
        }
        else
            System.out.println(result);
        
        sc.close();
    }
}