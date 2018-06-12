package easy.tree;
/**
 * Find the number of paths that sum to a given value.
 * @author wenhanglei
 */
public class PathSumIII {
	/*
	 * 思路：
	 * 任何一种遍历都可以
	 */
	public int pathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }
	
	/**
	 * @param node 目标二叉树节点
	 * @param num 已经过的路径的路径和
	 * @param sum 目标路径和
	 * @return 以该节点为根的二叉树的路径数量
	 */
	private int helper(TreeNode node, int num, int sum){
		if(node == null || node.val+num > sum) return 0;
		if(node.val+num == sum) return 1;
		return helper(node.left, node.val+num, sum)
				+helper(node.right, node.val+num, sum);
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
