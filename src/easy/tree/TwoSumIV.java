package easy.tree;

import java.util.Stack;

/**
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * @author wenhanglei
 */
public class TwoSumIV {
	
	private boolean hasSum = false;
	
	/*
	 * 思路：双指针
	 */
	public boolean findTarget(TreeNode root, int k) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		int sum = 0;
		TreeNode node = null;
		node = root;
		stack1.push(node);
		while(node.left != null){
			stack1.push(node.left);
			node = node.left;
		}
		node = root;
		stack2.push(node);
		while(node.right != null){
			stack2.push(node.right);
			node = node.right;
		}
		while(stack1.peek() != stack2.peek()){
			sum = stack1.peek().val + stack2.peek().val;
			if(sum == k) return true;
			else if(sum < k){
				node = stack1.pop();
				if(node.right != null){
					node = node.right;
					stack1.push(node);
					while(node.left != null){
						stack1.push(node.left);
						node = node.left;
					}
				}
			}else{
				node = stack2.pop();
				if(node.left != null){
					node = node.left;
					stack2.push(node);
					while(node.right != null){
						stack2.push(node.right);
						node = node.right;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
