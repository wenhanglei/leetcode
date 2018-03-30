package easy.tree;
/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along 
 * the longest path from the root node down to the farthest leaf node.
 * @author wenhanglei
 */
public class MaximumDepthofBinaryTree {
	/*
	 * 思路：
	 * 动态规划
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {3, 9, 20, '#', '#', 15, 17};
		TreeNode tree = TreeUtils.getTree(arr);
		MaximumDepthofBinaryTree sol = new MaximumDepthofBinaryTree();
		int res = sol.maxDepth(tree);
		System.out.println(res);
	}
}
