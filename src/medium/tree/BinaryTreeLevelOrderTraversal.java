package medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * @author wenhanglei
 */
public class BinaryTreeLevelOrderTraversal {
	/*
	 * 思路：层序遍历即可
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ret = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(queue.peek() != null){
			List<Integer> list = new LinkedList<>();
			while(queue.peek() != null){
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			queue.poll();
			ret.add(list);
			queue.offer(null);
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
