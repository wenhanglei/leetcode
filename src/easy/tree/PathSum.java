package easy.tree;
/**
 * Given a binary tree and a sum, determine if 
 * the tree has a root-to-leaf path such that adding 
 * up all the values along the path equals the given sum.
 * @author wenhanglei
 */
public class PathSum {
	/*
	 * 思路：
	 * 中序遍历
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null){
			if(sum == root.val) return true;
		}else{
			return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
		}
		return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {5, 4, 8, 11, '#', 13, 4, 7, 2, '#', '#', '#', 1};
		int[] arr1 = {1, 2};
		int[] arr2 = {-2, '#', -3};
		TreeNode tree = TreeUtils.getTree(arr2);
		PathSum sol = new PathSum();
		boolean res = sol.hasPathSum(tree, -5);
		System.out.println(res);
	}
}
