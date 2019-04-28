package medium.tree;

import java.util.LinkedList;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * @author wenhanglei
 */
public class LowestCommonAncestorofBinaryTree {

	private LinkedList<TreeNode> list1;
	private LinkedList<TreeNode> list2;

	//方案二：递归查找可能的结果
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//边界检查
		if(root == null || root == p || root == q) { return root; }
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) { return root; }
		return left != null? left : right;

	}

	//方案一：使用两个链表保存并对比路径
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		inorder(root, p, q, new LinkedList<>());
//		int len = Math.min(list1.size(), list2.size());
//		TreeNode ret = null;
//		for(int i = 0; i < len; i++){
//			if(list1.get(i) == list2.get(i)) {
//				ret = list1.get(i);
//			}else {
//				break;
//			}
//		}
//		return ret;
//	}

//	private void inorder(TreeNode node, TreeNode p, TreeNode q, LinkedList<TreeNode>list){
//		if(node == null) {
//			return;
//		}
//		list.add(node);
//		if(node == p){
//			list1 = new LinkedList<>(list);
//		}
//		if(node == q){
//			list2 = new LinkedList<>(list);
//		}
//		inorder(node.left, p, q, list);
//		inorder(node.right, p, q, list);
//		list.removeLast();
//	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TreeUtils.getTree(nums);
		TreeNode p = TreeUtils.getTreeNode(root, 5);
		TreeNode q = TreeUtils.getTreeNode(root, 4);
		LowestCommonAncestorofBinaryTree sol = new LowestCommonAncestorofBinaryTree();
		TreeNode ret = sol.lowestCommonAncestor(root, p, q);
		System.out.println(ret.val);
	}
}
