package easy.tree;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * @author wenhanglei
 */
public class SubtreeAnotherTree {
	/*
	 * 思路：深度优先遍历
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
		//边界检查
		if(s == null) return false;
		if(isSame(s, t)) return true;
		else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	public boolean isSame(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		else if(t1 != null && t2 != null){
			if(isSame(t1.left, t2.left) && isSame(t1.right, t2.right))
				if(t1.val == t2.val) return true;
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
