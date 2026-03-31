import java.util.*;

public class QueueImplementation {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public QueueImplementation() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void enqueue(int x) {
		stack1.push(x);
		// System.out.println("Enqueued: " + x);
	}
	
	public int dequeue(){
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		if(stack2.isEmpty()) {
			System.out.println("Queue is Empty!");
			return -1;
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueImplementation queue = new QueueImplementation();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

        System.out.println("Enqueued Stack: " + queue.stack1);

		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Dequeued: " + queue.dequeue());

		
	}
}
