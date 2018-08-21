package easy.tree;

/**
 * Given the root node of a binary search tree (BST) and a value. You need to
 * find the node in the BST that the node's value equals the given value. Return
 * the subtree rooted with that node. If such node doesn't exist, you should
 * return NULL.
 * 
 * @author wenhanglei
 *
 */
public class SearchInBSTree {
	/*
	 * 思路：二叉排序树搜索
	 */
	public TreeNode searchBST(TreeNode root, int val) {
		//边界检查
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val < val){
        	return searchBST(root.right, val);
        }else{
        	return searchBST(root.left, val);
        }
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SearchInBSTree sol = new SearchInBSTree();
		TreeNode tree = TreeUtils.getTree(new int[]{4, 2, 7, 1, 3});
		TreeNode node = sol.searchBST(tree, 2);
		System.out.println(node);
	}
}
