package medium.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * @author wenhanglei
 */
public class UniqueBinarySearchTreesII {
	/*
	 * 思路：分治法解决
	 */
	public List<TreeNode> generateTrees(int n) {
		//边界检查
		List<TreeNode> ret = new LinkedList<>();
		if(n <= 0) return ret;
		ret = helper(1, n);
		return ret;
	}
	
	private List<TreeNode> helper(int lo, int hi){
		if(lo > hi) return null;
		List<TreeNode> list = new LinkedList<>();
		for(int i = lo; i <= hi; i++){
			List<TreeNode> left = helper(lo, i-1);
			List<TreeNode> right = helper(i+1, hi);
			if(left != null) {
				for (TreeNode treeNode : left) {
					if(right != null){
						for (TreeNode n : right) {
							TreeNode node = new TreeNode(i);
							node.left = treeNode;
							node.right = n;
							list.add(node);
						}
					}else{
						TreeNode node = new TreeNode(i);
						node.left = treeNode;
						list.add(node);
					}
				}
			}else{
				if(right != null){
					for (TreeNode n : right) {
						TreeNode node = new TreeNode(i);
						node.right = n;
						list.add(node);
					}
				}else list.add(new TreeNode(i));
			}
		}
		return list;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
		sol.generateTrees(3);
	}
}
