package medium.tree;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST. Calling next() will return the next
 * smallest number in the BST.
 * 
 * @author wenhanglei
 */
public class BinarySearchTreeIterator {
	
	/*
	 * 思路：使用栈保存下一个节点
	 */
	Stack<TreeNode> stack = new Stack<>();
	
	public BinarySearchTreeIterator(TreeNode root) {
		TreeNode curr = root;
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = stack.pop();
		TreeNode curr = temp.right;
		while(curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		return temp.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack.size() > 0;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		TreeNode temp = new TreeNode(15);
		temp.left = new TreeNode(9);
		temp.right = new TreeNode(20);
		root.right = temp;
		BinarySearchTreeIterator sol = new BinarySearchTreeIterator(root);
		while(sol.hasNext()){
			System.out.println(sol.next());
		}
	}
}
