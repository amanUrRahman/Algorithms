package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NGR {

	private static List<Integer> nextGreatRight(int check[]) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();

		for (int i = check.length - 1; i >= 0;) {
			if (stack.isEmpty()) {
				result.add(-1);
				stack.push(check[i]);
				i--;
			} else if (!stack.isEmpty() && check[i] < stack.peek()) {
				result.add(stack.peek());
				stack.push(check[i]);
				i--;
			} else if (!stack.isEmpty() && check[i] > stack.peek()) {
				stack.pop();
			}
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		int check[] = { 1, 3, 2, 4 };
		System.out.println(nextGreatRight(check));

	}

}
