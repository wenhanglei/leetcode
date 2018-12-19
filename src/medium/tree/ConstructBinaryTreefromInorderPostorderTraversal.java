package medium.tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author wenhanglei
 */
public class ConstructBinaryTreefromInorderPostorderTraversal {
	/*
	 * 思路： 跟使用前序重建一个思路
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length, postorder, postorder.length-1);
	}
	
	private TreeNode helper(int[] inorder, int lo, int hi, int[] postorder, int curr){
		if(lo >= hi) return null;
		
		TreeNode node = new TreeNode(postorder[curr]);
		
		int len = 1;
		int idx = hi-1;
		while(inorder[idx] != postorder[curr]){
			idx--;
			len++;
		}
		
		node.left = helper(inorder, lo, idx, postorder, curr-len);
		node.right = helper(inorder, idx+1, hi, postorder, curr-1);
		return node;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		ConstructBinaryTreefromInorderPostorderTraversal sol = new ConstructBinaryTreefromInorderPostorderTraversal();
		TreeNode ret = sol.buildTree(inorder, postorder);
		System.out.println(ret);
	}
}
