package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MAH {

	private static List<Integer> nearestSmallestLeft(int height[]) {
		Stack<Block> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < height.length;) {
			if (stack.isEmpty()) {
				result.add(-1);
				stack.push(new Block(height[i], i));
				i++;
			} else if (!stack.isEmpty() && stack.peek().getValue() >= height[i]) {
				stack.pop();
			} else if (!stack.isEmpty() && stack.peek().getValue() < height[i]) {
				result.add(stack.peek().getIndex());
				stack.push(new Block(height[i], i));
				i++;
			}
		}
		return result;
	}

	private static List<Integer> nearestSmallestRight(int height[]) {
		Stack<Block> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		for (int i = height.length - 1; i >= 0;) {
			if (stack.isEmpty()) {
				result.add(height.length);
				stack.push(new Block(height[i], i));
				i--;
			} else if (!stack.isEmpty() && stack.peek().getValue() >= height[i]) {
				stack.pop();
			} else if (!stack.isEmpty() && stack.peek().getValue() < height[i]) {
				result.add(stack.peek().getIndex());
				stack.push(new Block(height[i], i));
				i--;
			}
		}
		Collections.reverse(result);
		return result;
	}

	public static int maximumAreaHistogram(int height[]) {
		List<Integer> left = nearestSmallestLeft(height);
		List<Integer> right = nearestSmallestRight(height);
		List<Integer> area = new ArrayList<>();
		for (int i = 0; i < height.length; i++) {
			area.add((right.get(i) - left.get(i) - 1) * height[i]);
		}
		return Collections.max(area);
	}

	public static void main(String[] args) {
		int height[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(maximumAreaHistogram(height));
	}
}
