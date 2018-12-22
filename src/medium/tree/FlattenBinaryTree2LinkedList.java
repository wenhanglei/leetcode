package medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author wenhanglei
 */
public class FlattenBinaryTree2LinkedList {
	/*
	 * 思路：使用链表保存中序遍历即可
	 */
	public void flatten(TreeNode root) {
		if(root == null) return;
		List<TreeNode> list = new ArrayList<>();
		helper(list, root);
		for(int i = 0; i < list.size()-1; i++){
			list.get(i).left = null;
			list.get(i).right = list.get(i+1);
		}
		list.get(list.size()-1).left = null;
	}
	
	private void helper(List<TreeNode> list, TreeNode node){
		if(node == null) return;
		list.add(node);
		helper(list, node.left);
		helper(list, node.right);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
