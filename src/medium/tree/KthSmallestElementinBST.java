package medium.tree;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * @author wenhanglei
 */
public class KthSmallestElementinBST {
	Integer ret;
	int count = 0;
	/*
	 * 思路：方案一中序遍历即可
	 */
	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return ret;
	}
	
	private void inorder(TreeNode node, int k){
		if(node ==null || ret == null) return;
		inorder(node.left, k);
		count++;
		if(count == k) ret = node.val;
		inorder(node.right, k);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
	}
}
