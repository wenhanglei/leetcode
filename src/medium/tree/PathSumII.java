package medium.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author wenhanglei
 */
public class PathSumII {
	/*
	 * 思路：递归查找即可
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		helper(ret, root, sum, list);
		return ret;
	}
	
	private void helper(List<List<Integer>> ret, TreeNode node, int rem, List<Integer> list){
		if(node == null) return;
		rem -= node.val;
		list.add(node.val);
		if(rem == 0) {
			if(node.left == null && node.right == null)
				ret.add(new LinkedList<>(list));
		}
		helper(ret, node.left, rem, list);
		helper(ret, node.right, rem, list);
		list.remove(list.size()-1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
//		TreeNode node = TreeUtils.getTree(new int[]{5,4,8,11,'#',13,4,7,2,'#','#','#', '#', 5,1});
		TreeNode node = TreeUtils.getTree(new int[]{-2, '#', -3});
		PathSumII sol = new PathSumII();
		List<List<Integer>> ret = sol.pathSum(node, -5);
		System.out.println(ret);
	}
}
