import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of list: ");
        int n= sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("List: ");
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        System.out.println("Original List: " + list);
        sc.close();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(!result.contains(list.get(i)))
                result.add(list.get(i));
        }
        System.out.println("Updated List: " + result);
    }
}
