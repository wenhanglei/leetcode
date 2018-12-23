package medium.tree;

import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author wenhanglei
 */
public class FlattenBinaryTree2LinkedList {
	/*
	 * 思路：使用链表保存中序遍历即可
	 * 方案二：使用栈来搞一哈
	 */
	public void flatten(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode pre = null;
		while(!stack.isEmpty()){
			TreeNode curr = stack.pop();
			if(pre != null){
				pre.left = null;
				pre.right = curr;
			}
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
			pre = curr;
		}
	}
//	public void flatten(TreeNode root) {
//		if(root == null) return;
//		List<TreeNode> list = new ArrayList<>();
//		helper(list, root);
//		for(int i = 0; i < list.size()-1; i++){
//			list.get(i).left = null;
//			list.get(i).right = list.get(i+1);
//		}
//		list.get(list.size()-1).left = null;
//	}
	
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
