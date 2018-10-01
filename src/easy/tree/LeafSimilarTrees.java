package easy.tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Consider all the leaves of a binary tree. From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * @author wenhanglei
 */
public class LeafSimilarTrees {
	/*
	 * 思路： 分别遍历两个二叉树，保存叶子序列即可
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		inOrder(root1, list1);
		inOrder(root2, list2);
		if(list1.size() != list2.size()) return false;
		Iterator<Integer> iter2 = list2.iterator();
		for(int i : list1){
			if(iter2.next() != i) return false;
		}
		return true;
	}
	
	private void inOrder(TreeNode node, LinkedList<Integer> list){
		if(node == null) return;
		inOrder(node.left, list);
		if(node.left == null && node.right == null) list.add(node.val);
		inOrder(node.right, list);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
