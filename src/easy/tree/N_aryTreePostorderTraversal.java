package easy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * 
 * @author wenhanglei
 */
public class N_aryTreePostorderTraversal {
	/*
	 * 思路：后续遍历即可
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> list = new LinkedList<>();
		//边界检查
		if(root == null) return list;
		postOrder(root, list);
		return list;
	}
	
	private void postOrder(Node n, List<Integer> list){
		if(n == null) return;
		for(Node w : n.children){
			postOrder(w, list);
		}
		list.add(n.val);
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
