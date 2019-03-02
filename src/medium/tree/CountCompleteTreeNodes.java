package medium.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * @author wenhanglei
 */
public class CountCompleteTreeNodes {
	/*
	 * 思路：知道一个树的顶点遍历最左边的节点可得到当前树的高度
	 */
	public int countNodes(TreeNode root) {
		if(root == null) return 0;
		int leftHeight = height(root.left);      //左子树的高度
		int rightHeight = height(root.right);    //右子树的高度
		if(leftHeight == rightHeight) {          //如果左右子树高度相同，则最后一个节点在右子树
			return countNodes(root.right) + (int)Math.pow(2, leftHeight);
		}else {
			return countNodes(root.left) + (int)Math.pow(2, rightHeight);
		}
	}
	
	private int height(TreeNode node){
		if(node == null) return 0;
		return height(node.left)+1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
