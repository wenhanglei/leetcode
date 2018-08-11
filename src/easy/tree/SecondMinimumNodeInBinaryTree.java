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
	}
	
	private int find(TreeNode node){
		
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
