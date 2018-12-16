package medium.tree;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author wenhanglei
 */
public class ConstructBinaryTreefromPreorderInorderTraversal {
	/*
	 * 思路：
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode node = new TreeNode(preorder[0]);
	}
	public TreeNode helper(int[] preorder, int[] inorder, int lo, int hi){
		TreeNode node = new TreeNode(preorder[lo]);
		int i = lo+1;
		for(; i <= hi; i++) if(inorder[i] == preorder[lo]) break;
		node.left = helper(preorder, inorder, lo, i-1);
		node.right = helper(preorder, inorder, i+1, hi);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
