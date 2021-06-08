package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) {
		// create tree
		TreeNode root = new TreeNode(12);
		// Left Sub-tree
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(5);
		root.left.right = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		// Right Sub-tree
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(23);
		root.right.right.right = new TreeNode(30);
		root.right.right.right.right = new TreeNode(50);

		preorderWithoutRecursion(root);

	}

	public static void postorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				if(current.right!=null)
					numbers.push(current.right);
				numbers.push(current);
				current = current.left;
				continue;
			} else {

			}
		}

	}

	public static void preorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				System.out.print(current.data + " ");
				numbers.push(current);
				current = current.left;
				continue;
			} else {
				if (current == null && !numbers.empty()) {
					current = numbers.pop();
					current = current.right;
					continue;
				} else
					break;
			}
		}
	}

	public static void mirrorTree(TreeNode root) {
		if (root == null)
			return;
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		int leftDiameter = diameterOfTree(root.left);
		int rightDiameter = diameterOfTree(root.right);
		return max(leftHeight + rightHeight + 1, max(leftDiameter, rightDiameter));
	}

	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		return max(leftHeight, rightHeight) + 1;
	}

	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> traversal = new LinkedList<TreeNode>();
		TreeNode current = root;
		traversal.add(current);
		while (current != null) {
			if (current.left != null)
				traversal.add(current.left);
			if (current.right != null)
				traversal.add(current.right);
			System.out.print(traversal.peek().data + " ");
			traversal.poll();
			current = traversal.peek();
		}
	}

	public static void inorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				numbers.push(current);
				current = current.left;
				continue;
			} else {
				if (current == null && !numbers.empty()) {
					current = numbers.pop();
					System.out.print(current.data + " ");
					current = current.right;
					continue;
				} else
					break;
			}
		}
	}

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static int max(int first, int second) {
		return first > second ? first : second;
	}
}
