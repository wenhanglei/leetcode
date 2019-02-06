package medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * @author wenhanglei
 */
public class BinaryTreeRightSideView {
	/*
	 * 思路：层序遍历保留最后一个节点即是结果集
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		if(root == null) return ret;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == null) continue;
			if(queue.peek() == null) ret.add(node.val);
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			if(queue.peek() == null) queue.offer(null); 
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
