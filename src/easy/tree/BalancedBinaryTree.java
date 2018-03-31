package easy.tree;
/**
 * Given a binary tree, determine if it is height-balanced.
 * @author wenhanglei
 */
public class BalancedBinaryTree {
	/*
	 * 思路：
	 * 深度优先遍历
	 * 这里完全没有必要使用成员变量作为标志位！！！
	 * 我们的目标是遍历整个二叉树的时候返回子树的高度的同时返回子树是否平衡
	 * 这里的是否平衡不一定非要用bool值表示可以用整型的-1代替
	 * 这样，当子树不平衡时子树高度返回为-1正好与返回高度兼容
	 * 所以可以不实用成员变量，返回结果已经涵盖了两种情况
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		return count(root) != -1;
    }
	
	/**
	 * 返回当前节点的高度
	 */
	private int count(TreeNode node){
		if(node == null) return 0;
		int lehi = count(node.left);
		if(lehi == -1) return -1;
		int rihi = count(node.right);
		if(rihi == -1) return -1;
		if(lehi - rihi > 1 || lehi - rihi < -1) return -1;
		return Math.max(lehi, rihi) + 1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {3,9,20,'#','#',15,7};
		int[] arr1 = {1,2,2,3,3,'#','#',4,4};
		TreeNode tree = TreeUtils.getTree(arr);
		BalancedBinaryTree sol = new BalancedBinaryTree();
		boolean res = sol.isBalanced(tree);
		System.out.println(res);
	}
}
