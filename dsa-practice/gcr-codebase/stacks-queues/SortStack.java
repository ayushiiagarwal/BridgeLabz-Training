import java.util.*;

public class SortStack {
	
	public static void empty(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		
		int top = stack.pop();
		
		empty(stack);
		
		sortedStack(stack, top);
	}
	
	public static void sortedStack(Stack<Integer> stack, int element) {
		if(stack.isEmpty() || element > stack.peek()) {
			stack.push(element);
			return;
		}
		int top = stack.pop();
		sortedStack(stack, element);
		stack.push(top);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(); 
		
		stack.push(12);
		stack.push(30);
		stack.push(18);
		stack.push(0);
		
		System.out.println("Initial Stack: " + stack);
		empty(stack);
		System.out.println("Sorted Stack: " + stack);
	}

}
