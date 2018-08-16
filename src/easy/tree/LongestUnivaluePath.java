package easy.tree;

/**
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * @author wenhanglei
 */
public class LongestUnivaluePath {
	
	private int max = 0;
	
	/*
	 * 思路：中序遍历
	 */
	public int longestUnivaluePath(TreeNode root) {
		inOrder(root);
		return max;
	}
	private void inOrder(TreeNode node){
		if(node == null) return;
		int temp = depth(node.left, node.val)+depth(node.right, node.val);
		max = Math.max(temp, max);
		inOrder(node.left);
		inOrder(node.right);
	}
	
	private int depth(TreeNode node, int val){
		if(node == null || node.val != val) return 0;
		return Math.max(depth(node.left, val), depth(node.right, val))+1;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeNode root = TreeUtils.getTree(new int[]{5,4,5,1,1,5});
		LongestUnivaluePath sol = new LongestUnivaluePath();
		int ret = sol.longestUnivaluePath(root);
//		int ret = sol.depth(root, 5);
		System.out.println(ret);
	}
}
