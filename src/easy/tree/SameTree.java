package easy.tree;

import java.util.Arrays;

/**
 * Given two binary trees, write a function to 
 * check if they are the same or not.
 * Two binary trees are considered the same if 
 * they are structurally identical and the nodes have the same value.
 * @author wenhanglei
 */
public class SameTree {
	/*
	 * 思路：
	 * 递归
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p != null & q != null){
			if(p.val != q.val) return false;
			if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
				return true;
		}
		return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 1};
		int[] arr2 = {1, 1, 2};
		TreeNode p = TreeUtils.getTree(arr1);
		TreeNode q = TreeUtils.getTree(arr2);
		SameTree sol = new SameTree();
		boolean res = sol.isSameTree(p, q);
		System.out.println(res);
	}
}
