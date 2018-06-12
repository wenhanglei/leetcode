package easy.tree;

import java.util.Queue;

/**
 * Find the number of paths that sum to a given value.
 * @author wenhanglei
 */
public class PathSumIII {
	/*
	 * 思路：
	 * 深度优先遍历
	 */
	public int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;
		return helper(root, sum) + pathSum(root.left, sum)
				+ pathSum(root.right, sum);
    }
	
	
	/**
	 * 以node为起点路径时，满足条件的路径数量
	 */
	private int helper(TreeNode node, int sum){
		if(node == null) return 0;
		return (sum == node.val?1:0)+helper(node.left, sum-node.val) + helper(node.right, sum-node.val);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PathSumIII sol = new PathSumIII();
		int[] arr = {10,5,-3,3,2,'#',11,3,-2,'#',1};
		TreeNode root = TreeUtils.getTree(arr);
		int ret = sol.pathSum(root, 8);
		System.out.println(ret);
	}
}
