import java.util.*;
public class ReverseQueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of Queue: ");
        int n = sc.nextInt();

        System.out.println("Elements: ");
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++)
            queue.push(sc.nextInt());

        System.out.println(queue);

        sc.close();

    }
}