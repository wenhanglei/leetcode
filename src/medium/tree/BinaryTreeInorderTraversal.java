package medium.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author wenhanglei
 */
public class BinaryTreeInorderTraversal {
	/*
	 * 思路：简单的中序遍历即可
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		//边界检查
		List<Integer> list = new LinkedList<>();
		if(root == null) return list;
		inorder(root, list);
		return list;
	}
	
	private void inorder(TreeNode node, List<Integer> list){
		if(node == null) return;
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
