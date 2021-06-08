package stack;

import java.util.Stack;

public class MinStackBest {

	Stack<Integer> stack = new Stack<>();
	int minElement;

	private void push(int element) {
		if (stack.isEmpty()) {
			stack.push(element);
			minElement = element;
		} else {
			if (element >= minElement)
				stack.push(element);
			else if (element < minElement) {
				stack.push(2 * element - minElement);
				minElement = element;
			}
		}
	}

	private int pop() {

		if (stack.isEmpty())
			return -1;
		else if (stack.peek() >= minElement)
			return stack.pop();
		else {
			int minimum = minElement;
			minElement = 2 * minElement - stack.peek();
			stack.pop();
			return minimum;
		}
	}

	private int minElement() {
		if (stack.isEmpty())
			return -1;
		return minElement;
	}

	private int top() {
		if (stack.isEmpty())
			return -1;
		else if (stack.peek() >= minElement)
			return stack.peek();
		else
			return minElement;
	}

	public static void main(String[] args) {
		MinStackBest a = new MinStackBest();
		a.push(18);
		a.push(19);
		a.push(29);
		a.push(15);
		a.push(16);
		System.out.println(a.minElement());
		a.pop();
		System.out.println(a.minElement());
		a.pop();
		System.out.println(a.minElement());
	}
}
