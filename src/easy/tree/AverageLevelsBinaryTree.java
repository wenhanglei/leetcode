package easy.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * @author wenhanglei
 */
public class AverageLevelsBinaryTree {
	/*
	 * 思路：层序遍历即可
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		//边界检查
		if(root == null) return null;
		//结果变量
		List<Double> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		TreeNode temp = null;
		while(queue.peek() != null){
			int divider = 0;
			long sum = 0;
			while((temp = queue.poll()) != null){
				divider++;
				sum += temp.val;
				if(temp.left != null) queue.offer(temp.left);
				if(temp.right != null) queue.offer(temp.right);
			}
			list.add((double)sum/divider);
			queue.offer(null);
			
		}
		return list;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		long i = 2147483647;
		System.out.println((double)(i+i)/2);
	}
}
