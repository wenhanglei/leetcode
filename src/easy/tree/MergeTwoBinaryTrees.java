package easy.tree;

/**
 * 
 * Given two binary trees and imagine that when you put one of them to cover the
 * other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * @author wenhanglei
 */
public class MergeTwoBinaryTrees {
	/*
	 * 思路：递归即可
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//边界检查
		if(t1 == null || t2 == null) return t1 == null ? t2:t1;
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
