package medium.tree;

import java.util.LinkedList;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST. Calling next() will return the next
 * smallest number in the BST.
 * 
 * @author wenhanglei
 */
public class BinarySearchTreeIterator {
	
	/*
	 * 思路：使用链表保存二叉遍历序列即可
	 */
	LinkedList<TreeNode> list = new LinkedList<>();
	int curr = 0;            //当前元素的下标
	
	public BinarySearchTreeIterator(TreeNode root) {
		inorder(root);
	}
	
	/**
	 * 中序遍历二叉树
	 */
	private void inorder(TreeNode node){
		if(node == null) return;
		inorder(node.left);
		list.add(node);
		inorder(node.right);
	}

	/** @return the next smallest number */
	public int next() {
		return list.get(curr++).val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return curr < list.size();
	}
}
