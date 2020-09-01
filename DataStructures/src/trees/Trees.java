package trees;

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

		levelOrderTraversal(root);
	}

	public static void levelOrderTraversal(TreeNode root) {

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
		inorder(root);
	}
}
