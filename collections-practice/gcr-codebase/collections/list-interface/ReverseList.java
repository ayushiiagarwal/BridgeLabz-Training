import java.util.*;

public class ReverseList{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int i = 0, j = list.size() - 1;

        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

            i++;
            j--;
        }

        System.out.println("ArrayList: " + list);

        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> reversed = new LinkedList<>();

        for (int k = list1.size() - 1; k >= 0; k--) {
            reversed.add(list1.get(k));
        }

        System.out.println("LinkedList: " + reversed);
    }
}