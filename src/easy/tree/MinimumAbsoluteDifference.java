package easy.tree;

/**
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * @author wenhanglei
 */
public class MinimumAbsoluteDifference {
	
	int min = Integer.MAX_VALUE;
	int preNum = -1;
	/*
	 * 思路：
	 * 中序遍历返回最小差异
	 */
	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return min;
	}
	
	private void inorder(TreeNode node){
		if(node == null) return;
		inorder(node.left);
		handle(node.val);
		inorder(node.right);
	}
	
	private void handle(int num){
		if(preNum != -1) min = (num-preNum)<min?(num-preNum):min;
		preNum = num;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
