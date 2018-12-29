package medium.tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number. An example is the root-to-leaf path 1->2->3 which
 * represents the number 123.
 * 
 * @author wenhanglei
 */
public class SumRoot2LeafNumbers {
	int sum = 0;
	/*
	 * 思路：深度优先遍历即可
	 */
	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return sum;
	}
	
	private void helper(TreeNode node, int num){
		if(node == null) return;
		if(node.left == null && node.right == null){
			sum += (num*10+node.val);
		}
		if(node.left != null) helper(node.left, num*10+node.val);
		if(node.right != null) helper(node.right, num*10+node.val);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
