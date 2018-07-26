package easy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * 
 * @author wenhanglei
 */
public class N_aryTreePreorderTraversal {
	/*
	 * 思路：前序遍历即可
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> list = new LinkedList<>();
		//边界判断
		if(root == null) return list;
		inorder(root, list);
		return list;
	}
	
	private void inorder(Node n, List<Integer> list){
		if(n == null) return;
		list.add(n.val);
		for(Node w : n.children){
			inorder(w, list);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
