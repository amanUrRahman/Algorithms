package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

	private static List<Integer> stockSpan(int check[]) {
		Stack<Block> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < check.length;) {
			if (stack.isEmpty()) {
				result.add(1);
				stack.push(new Block(check[i], i));
				i++;
			} else if (!stack.isEmpty() && check[i] < stack.peek().getValue()) {
				result.add(i - stack.peek().getIndex());
				stack.push(new Block(check[i], i));
				i++;
			} else if (!stack.isEmpty() && check[i] >= stack.peek().getValue()) {
				stack.pop();
			}
		}

		/*
		 * for (int i = 0; i < result.size(); i++) result.set(i, i - result.get(i));
		 */
		return result;
	}

	public static void main(String[] args) {
		int check[] = { 100, 80, 60, 70, 60, 75, 85 };
		System.out.println(stockSpan(check));

	}

}
