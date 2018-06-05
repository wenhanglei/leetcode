package easy.tree;
/**
 * Find the sum of all left leaves in a given binary tree.
 * @author wenhanglei
 */
public class SumOfLeftLeaves {
	/*
	 * 思路：
	 * 遍历并判断保存
	 */
	public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, null);
    }
	
	private int traverse(TreeNode node, TreeNode parent){
		if(node == null) return 0;
		if(node.left == null && node.right == null && parent != null && parent.left == node)
			return node.val;
		return traverse(node.left, node)+traverse(node.right, node);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SumOfLeftLeaves sol = new SumOfLeftLeaves();
		int[] arr = {3, 9, 20, '#', '#', 15, 7};
		TreeNode root = TreeUtils.getTree(arr);
		int ret = sol.sumOfLeftLeaves(root);
		System.out.println(ret);
	}
}
