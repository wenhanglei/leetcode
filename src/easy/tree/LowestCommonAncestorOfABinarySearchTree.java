package easy.tree;
/**
 * Given a binary search tree (BST), find the lowest 
 * common ancestor (LCA) of two given nodes in the BST.
 * @author wenhanglei
 */
public class LowestCommonAncestorOfABinarySearchTree {
	/*
	 * 思路：
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val < root.val && q.val < root.val){
			return lowestCommonAncestor(root.left, p, q);
		}else if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestor(root.right, p, q);
		}else return root;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
