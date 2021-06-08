package stack;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> sStack = new Stack<>();

	private int minElement() {

		if (sStack.isEmpty())
			return -1;
		return sStack.peek();
	}

	private void push(int element) {
		stack.push(element);
		if (sStack.isEmpty() || sStack.peek() >= element)
			sStack.push(element);
	}

	private int pop() {
		if (stack.isEmpty())
			return -1;
		int element = stack.pop();
		if (sStack.peek() == element)
			sStack.pop();
		return element;
	}

	public static void main(String[] args) {
		MinStack a = new MinStack();
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
