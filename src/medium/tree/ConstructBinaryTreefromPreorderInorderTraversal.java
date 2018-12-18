package medium.tree;

import java.util.HashMap;

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
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
	}
	
	private TreeNode helper(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi, HashMap<Integer,Integer> map){
		if(plo >= phi) return null;
		TreeNode node = new TreeNode(preorder[plo]);
		int idx = map.get(preorder[plo]);
		node.left = helper(preorder, plo+1, idx-ilo+plo+1, inorder, ilo, idx, map);
		node.right = helper(preorder, idx-ilo+plo+1, phi, inorder, idx+1, ihi, map);
		return node;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		ConstructBinaryTreefromPreorderInorderTraversal sol = new ConstructBinaryTreefromPreorderInorderTraversal();
		TreeNode ret = sol.buildTree(preorder, inorder);
		System.out.println(ret);
	}
}
