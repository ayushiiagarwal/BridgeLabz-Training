import java.util.*;

class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    int pop() {
        return queue1.remove();
    }

    int top() {
        return queue1.peek();
    }
}

public class StackTest {
    public static void main(String[] args) {

        StackUsingQueue s = new StackUsingQueue();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Pop: " + s.pop());
    }
}