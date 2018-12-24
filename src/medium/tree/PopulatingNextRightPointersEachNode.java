package medium.tree;


/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL. Initially, all next
 * pointers are set to NULL.
 * 
 * @author wenhanglei
 */
public class PopulatingNextRightPointersEachNode {
	/*
	 * 思路：使用递归即可
	 */
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		helper(root, null);
	}
	
	private void helper(TreeLinkNode node, TreeLinkNode uper){
		if(node.left == null || node.right == null) return;
		if(uper == null) {
			node.left.next = node.right;
			helper(node.left, null);
		}else{
			uper.right.next = node.left;
			node.left.next = node.right;
			helper(node.left, uper.right);
		}
		helper(node.right, node.left);
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {

	}
}
