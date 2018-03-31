package easy.tree;
/**
 * Given a binary tree, determine if it is height-balanced.
 * @author wenhanglei
 */
public class BalancedBinaryTree {
	boolean res;
	/*
	 * 思路：
	 * 深度优先遍历
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		res = true;
		count(root);
        return res;
    }
	
	/**
	 * 返回当前节点的高度
	 */
	private int count(TreeNode node){
		if(node == null || !res) return 0;
		int lehi = count(node.left);
		int rihi = count(node.right);
		if(Math.abs(rihi-lehi) > 1) res = false;
		return Math.max(count(node.left), count(node.right)) + 1;
	}
	
	private void search(TreeNode node){
		
		search(node.left);
		search(node.right);
		
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {3,9,20,'#','#',15,7};
		int[] arr1 = {1,2,2,3,3,'#','#',4,4};
		TreeNode tree = TreeUtils.getTree(arr1);
		BalancedBinaryTree sol = new BalancedBinaryTree();
		boolean res = sol.isBalanced(tree);
		System.out.println(res);
	}
}
