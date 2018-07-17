package easy.tree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * @author wenhanglei
 */
public class DiameterBinaryTree {

	/*
	 * 思路：
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftLen = longestPath(root.left);
		int rightLen = longestPath(root.right);
		return Math.max(diameterOfBinaryTree(leftLen > rightLen ? root.left
				: root.right), leftLen + rightLen);

	}

	private int longestPath(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(longestPath(node.left), longestPath(node.right)) + 1;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {

	}
}
