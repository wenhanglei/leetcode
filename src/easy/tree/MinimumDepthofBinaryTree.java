package easy.tree;
/**
 * Given a binary tree, find its minimum depth.
 * @author wenhanglei
 */
public class MinimumDepthofBinaryTree {
	
	private int minDepth = Integer.MAX_VALUE;
	
	/*
	 * 思路：
	 * 动态规划
	 */
	public int minDepth(TreeNode root) {
		//边界判断
		if(root == null) return 0;
		//左子树的最小高度
		int lemi = minDepth(root.left);
		int rimi = minDepth(root.right);
		if(lemi == 0 && rimi != 0) return rimi+1;
		if(rimi == 0 && lemi != 0) return lemi+1;
		return Math.min(lemi, rimi) + 1;
    }
	
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {3, 9};
		TreeNode tree = TreeUtils.getTree(arr);
		MinimumDepthofBinaryTree sol = new MinimumDepthofBinaryTree();
		int res = sol.minDepth(tree);
		System.out.println(res);
	}
}
