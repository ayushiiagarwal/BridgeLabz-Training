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

        // another way..
        
        // Queue<Integer> queue = new LinkedList<>();
        // for(int i=0;i<n;i++)
        //     queue.add(sc.nextInt());

        // System.out.println("Input: " + queue);

        // Stack<Integer> stack = new Stack<>();

        // while(!queue.isEmpty()){
        //     stack.push((queue.remove()));
        // }

        // while (!stack.isEmpty()) {
        //     queue.add(stack.pop());
        // }

        // System.out.println("Output: " + queue);

        sc.close();
    }
}