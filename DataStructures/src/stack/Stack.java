package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	public int top;
	public List<String> stack;

	Stack() {
		top = -1;
		stack = new ArrayList<String>();
	}

	// Method to insert an element into the stack
	public void push(String toBePushed) {
		stack.add(toBePushed);
		top++;
		System.out.println("The element " + toBePushed + " has been inserted at position " + (top));
	}

	// Method to remove the latest element from the stack
	public void pop() {
		if (isEmpty()) {
			System.out.println("The Stack is empty");
		} else {
 			String removedElement = stack.get(top);
			stack.remove(top);
			System.out.println("The element " + removedElement + " has been removed from position " + (top));
			top--;
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

	public String elementAtTop() {
		if (this.isEmpty()) {
			System.out.println("The Stack is empty");
			return "-1";
		}
		return stack.get(top);
	}

}
