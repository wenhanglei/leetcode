package medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author wenhanglei
 */
public class BinaryTreePreorderTraversal {
	/*
	 * 思路：简单的实现前序遍历即可
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		helper(root, ret);
		return ret;
	}
	
	private void helper(TreeNode node, List<Integer> list){
		if(node == null) return;
		list.add(node.val);
		helper(node.left, list);
		helper(node.right, list);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
