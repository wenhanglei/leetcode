package easy.tree;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum
 * difference between the values of any two different nodes in the tree.
 * 
 * @author wenhanglei
 */
public class MinimumDistanceBetweenBSTNodes {
	
	private TreeNode preNode;
	private int min;
	/*
	 * 思路：中序遍历保存最小的差距即可
	 */
	public int minDiffInBST(TreeNode root) {
		min = Integer.MAX_VALUE;
		inOrder(root);
		return min;
	}
	
	private void inOrder(TreeNode node){
		if(node == null) return;
		inOrder(node.left);
		if(preNode != null)
			min = Math.min(node.val-preNode.val, min);
		preNode = node;
		inOrder(node.right);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
	}
}
