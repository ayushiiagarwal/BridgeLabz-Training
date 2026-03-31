import java.util.*;

public class ElementFromEnd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<String> list = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }


        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sc.close();

        System.out.println("List: " + list);

        int first = 0;
        int second = 0;

        for (int i = 0; i < N; i++) {
            first++;
        }

        while (first < list.size()) {
            first++;
            second++;
        }

        System.out.println("Nth element from end: " + list.get(second));
    }
}
