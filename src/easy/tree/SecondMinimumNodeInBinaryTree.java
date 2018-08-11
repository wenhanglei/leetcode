package easy.tree;

/**
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * @author wenhanglei
 */
public class SecondMinimumNodeInBinaryTree {
	/*
	 * 思路：
	 */
	public int findSecondMinimumValue(TreeNode root) {
		if(root == null) return -1;
		if(root.left == null && root.right == null) return -1;
		if(root.left.val == root.val && root.right.val == root.val){
			int left = findSecondMinimumValue(root.left);
			int right = findSecondMinimumValue(root.right);
			if(left == -1 && right == -1) return -1;
			else if(left == -1) return right;
			else if(right == -1) return left;
			else return Math.min(left, right);
		}else if(root.left.val == root.val){
			int val = findSecondMinimumValue(root.left);
			if(val == -1) return root.right.val;
			else return Math.min(root.right.val, val);
		}else if(root.right.val == root.val){
			int val = findSecondMinimumValue(root.right);
			if(val == -1) return root.left.val;
			else return Math.min(root.left.val, val);
		}else return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
