package easy.tree;
/**
 * 
 * @author wenhanglei
 */
public class IncreasingOrderSearchTree {
	private TreeNode preNode;
	/*
	 * 思路：中序遍历在修改节点即可
	 */
	public TreeNode increasingBST(TreeNode root) {
		inOrder(root);
		TreeNode ret = preNode;
		while(preNode != null){
			preNode.left = null;
			preNode = preNode.right;
		}
		return ret;
	}
	
	private void inOrder(TreeNode node){
		if(node == null) return;
		inOrder(node.right);
		node.right = preNode;
		preNode = node;
		inOrder(node.left);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		IncreasingOrderSearchTree sol = new IncreasingOrderSearchTree();
		int[] arr = {3, 1, 4};
		TreeNode root = TreeUtils.getTree(arr);
		TreeNode ret = sol.increasingBST(root);
		System.out.println("hah");
	}
}
