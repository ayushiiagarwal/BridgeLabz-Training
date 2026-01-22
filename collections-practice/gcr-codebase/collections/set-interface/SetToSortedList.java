import java.util.*;
public class SetToSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of set: ");
        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        System.out.print("Set Elements: ");
        for(int i=0;i<n;i++)
            set.add(sc.nextInt());

        sc.close();

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println(list);
    }
}
