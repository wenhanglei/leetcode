package easy.tree;
/**
 * Invert a binary tree.
 * @author wenhanglei
 */
public class InvertBinaryTree {
	/*
	 * 思路：
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = invertTree(root.right);
		root.right = invertTree(root.left);
		root.left = temp;
        return root;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
