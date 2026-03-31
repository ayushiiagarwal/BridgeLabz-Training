import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {
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

        sc.close();

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> inter = new HashSet<>(set1);
        inter.retainAll(set2);
        
        union.removeAll(inter);

        System.out.println(union);
       

        
        // for(int i=0;i<set1.size();i++){
        //     for(int j=0;j<set2.size();j++){
        //         if(set1.contains(i) && set2.contains(i)){
        //             set1.remove(i);
        //         }
        //     }
        // }
    }    
}
