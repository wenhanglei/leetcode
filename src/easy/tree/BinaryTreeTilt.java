package easy.tree;

/**
 * Given a binary tree, return the tilt of the whole tree. The tilt of a tree
 * node is defined as the absolute difference between the sum of all left
 * subtree node values and the sum of all right subtree node values. Null node
 * has tilt 0. The tilt of the whole tree is defined as the sum of all nodes'
 * tilt.
 * 
 * @author wenhanglei
 */
public class BinaryTreeTilt {
	
	private int totalTilt = 0;

	/*
	 * 思路：
	 * 递归
	 */
	public int findTilt(TreeNode root) {
		if(root == null) return 0;
		inorder(root);
		return totalTilt;
	}
	
	private void inorder(TreeNode node){
		if(node == null) return;
		totalTilt += tiltOfNode(node);
		inorder(node.left);
		inorder(node.right);
	}
	
	private int tiltOfNode(TreeNode node){
		if(node == null) return 0;
		return Math.abs(sumOfChildren(node.left)-sumOfChildren(node.right));
	}
	
	private int sumOfChildren(TreeNode node){
		if(node == null) return 0;
		return sumOfChildren(node.left) + sumOfChildren(node.right) + node.val;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
