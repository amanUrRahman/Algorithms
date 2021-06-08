package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NSL {

	private static List<Integer> nextSmallLeft(int[] check) {

		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < check.length;) {

			if (stack.isEmpty()) {
				result.add(-1);
				stack.push(check[i]);
				i++;
			}
			else if (!stack.isEmpty() && check[i] > stack.peek()) {
				result.add(stack.peek());
				stack.add(check[i]);
				i++;
			}
			else if (!stack.isEmpty() && check[i] < stack.peek()) {
				stack.pop();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int check[] = { 4,5,6,1,2 };
		System.out.println(nextSmallLeft(check));

	}

}
