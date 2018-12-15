package medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * @author wenhanglei
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/*
	 * 思路：使用两个栈解决
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<List<Integer>> ret = new LinkedList<>();
		if(root == null) return ret;
		s1.add(root);
		while(true){
			List<Integer> list = new LinkedList<>();
			while(!s1.isEmpty()){
				TreeNode node = s1.pop();
				list.add(node.val);
				if(node.left != null) s2.push(node.left);
				if(node.right != null) s2.push(node.right);
			}
			if(!list.isEmpty()) ret.add(list);
			list = new LinkedList<>();
			while(!s2.isEmpty()){
				TreeNode node = s2.pop();
				list.add(node.val);
				if(node.right != null) s1.push(node.right);
				if(node.left != null) s1.push(node.left);
			}
			if(!list.isEmpty()) ret.add(list);
			if(s1.isEmpty() && s2.isEmpty()) break;
		}
		return ret;
	}
	
	private void helper(List<List<Integer>> ret, Stack<TreeNode> s1, Stack<TreeNode> s2){
		TreeNode node = null;
		List<Integer> list = new LinkedList<>();
		while((node = s1.pop()) != null){
			list.add(node.val);
			if(node.right != null) s2.push(node.right);
			if(node.left != null) s2.push(node.left);
		}
		ret.add(list);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TreeNode tree = TreeUtils.getTree(new int[]{3,9,20,'#','#',15,7});
		BinaryTreeZigzagLevelOrderTraversal sol = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> ret = sol.zigzagLevelOrder(tree);
		System.out.println(ret);
	}
}
