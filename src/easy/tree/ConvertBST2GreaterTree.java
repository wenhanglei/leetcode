package easy.tree;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * @author wenhanglei
 */
public class ConvertBST2GreaterTree {
	
	int sum = 0;
	/*
	 * 思路：
	 * 遍历两次，第一次求得所有的数相加的和，第二次依次减去当前节点的值，时间复杂度O(n)
	 */
	public TreeNode convertBST(TreeNode root) {
		preinorder(root);
		proinorder(root);
		return root;
	}
	
	private void preinorder(TreeNode node){
		if(node == null) return;
		preinorder(node.left);
		sum += node.val;
		preinorder(node.right);
	}
	
	private void proinorder(TreeNode node){
		if(node == null) return;
		proinorder(node.left);
		int temp = sum-node.val;
		node.val = sum;
		sum = temp;
		proinorder(node.right);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
