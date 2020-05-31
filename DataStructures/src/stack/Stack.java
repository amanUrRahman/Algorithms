package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	protected int top;
	// protected List<Integer> stack = new ArrayList<Integer>();
	@SuppressWarnings("rawtypes")
	protected List stack = new ArrayList();

	Stack() {
		top = -1;
	}

	// Method to insert an element into the stack
	@SuppressWarnings("unchecked")
	public void push(Object toBePushed) {
		stack.add(toBePushed);
		top = stack.size();
		System.out.println("The element " + toBePushed + " has been inserted at position " + (top - 1));
	}

	// Method to remove the latest element from the stack
	public void pop() {
		if (isEmpty()) {
			System.out.println("The Stack is empty");
		} else {
			top = stack.size();
			Object removedElement = stack.get(top - 1);
			stack.remove(top - 1);
			System.out.println("The element " + removedElement + " has been removed from position " + (top));
			top = stack.size();
		}
	}

	// Method to check whether the Stack is empty
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// Method to display the content of the Stack
	public void display() {
		if (this.isEmpty()) {
			System.out.println("The Stack is empty");
		} else {
			System.out.print("The contents of the Stack: ");
			for (Object elementInStack : stack) {
				System.out.print(elementInStack + " ");
			}
		}
		System.out.println();
	}

	// Method to display the size of the Stack
	public void size() {
		System.out.println("The size of the Stack is " + stack.size());
	}

	// Method to display the size of the Stack
	public void topPosition() {
		if (this.isEmpty()) {
			System.out.println("The Stack is empty");
		} else {
			System.out.println("The position of top is " + stack.size());
		}
	}

	public static void main(String[] args) {

		Stack a = new Stack();
		a.push(2);
		a.push("Aman");
		a.push(true);
		a.push(23.23);
		a.display();
		a.pop();
		a.display();
		
		

	}
}
