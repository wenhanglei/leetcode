package easy.tree;
/**
 * Given a binary tree, check whether it is a mirror of 
 * itself (ie, symmetric around its center).
 * @author wenhanglei
 */
public class SymmetricTree {
	/*
	 * 思路：
	 * 递归
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
        return isSym(root.left, root.right);
    }
	
	private boolean isSym(TreeNode l, TreeNode r){
		if(l == null && r == null) return true;
		else if(l != null && r != null){
			if(isSym(l.left, r.right) && isSym(l.right, r.left)){
				if(l.val == r.val) return true;
			}
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 4, 3};
		TreeNode tree = TreeUtils.getTree(arr);
		SymmetricTree sol = new SymmetricTree();
		boolean res = sol.isSymmetric(tree);
		System.out.println(res);
		
	}
}
