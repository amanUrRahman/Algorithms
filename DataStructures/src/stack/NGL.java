package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NGL {

	private static List<Integer> nextGreatLeft(int[] check) {

		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < check.length;) {
			if (stack.isEmpty()) {
				result.add(-1);
				stack.push(check[i]);
				i++;
			} else if (!stack.isEmpty() && check[i] > stack.peek()) {
				stack.pop();
			} else if (!stack.isEmpty() && check[i] < stack.peek()) {
				result.add(stack.peek());
				stack.push(check[i]);
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int check[] = { 1, 3, 2, 4 };
		System.out.println(nextGreatLeft(check));

	}

}
