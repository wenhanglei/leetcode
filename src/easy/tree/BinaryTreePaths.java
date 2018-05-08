package easy.tree;

import java.util.LinkedList;
import java.util.List;

import easy.linkedlist.ListNode;
import easy.linkedlist.ListUtils;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * @author wenhanglei
 */
public class BinaryTreePaths {
	List<Integer> list = new LinkedList<>();
	/*
	 * 思路：
	 * 先序遍历保存遍历路径
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ret = new LinkedList<>();
		if(root == null) return ret;
		help(root, ret);
        return ret;
    }
	
	private void help(TreeNode n, List<String> l){
		list.add(n.val);
		if(n.left == null && n.right == null){
			String s = "";
			for(int i : list){
				s += (i+"->");
			}
			l.add(s.substring(0,s.length()-2));
		}
		if(n.left != null) help(n.left, l);
		if(n.right != null) help(n.right, l);
		list.remove(list.size()-1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, '#', 5};
		TreeNode node = TreeUtils.getTree(arr);
		BinaryTreePaths sol = new BinaryTreePaths();
		List<String> res = sol.binaryTreePaths(node);
		System.out.println(res);
	}
}
