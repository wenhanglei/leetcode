package easy.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order 
 * traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * @author wenhanglei
 */
public class BinaryTreeLevelOrderTraversalII {
	/*
	 * 思路：
	 * 层序遍历
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		//边界检查
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while(queue.peek() != null){
			List<Integer> list = new ArrayList<>();
			TreeNode curr = null;
			while((curr = queue.poll()) != null){
				list.add(curr.val);
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
			res.add(list);
			queue.offer(null);
		}
		Collections.reverse(res);
        return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {3, 9, 20, '#', '#', 15, 7};
		TreeNode tree = TreeUtils.getTree(arr);
		BinaryTreeLevelOrderTraversalII sol = new BinaryTreeLevelOrderTraversalII();
		List<List<Integer>> res = sol.levelOrderBottom(tree);
		System.out.println(res);
	}
}
