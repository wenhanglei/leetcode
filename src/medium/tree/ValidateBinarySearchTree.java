package medium.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * @author wenhanglei
 */
public class ValidateBinarySearchTree {
	boolean isValid = true;
	int pre = -1;
	/*
	 * 思路：中序遍历一下如果非递增则不是排序二叉树
	 */
	public boolean isValidBST(TreeNode root) {
		inorder(root);
		return isValid;
	}
	
	private void inorder(TreeNode node){
		if(node == null) return;
		inorder(node.left);
		if(pre == -1) pre = node.val;
		else {
			if(node.val <= pre) isValid = false;
			pre = node.val;
		}
		inorder(node.right);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
