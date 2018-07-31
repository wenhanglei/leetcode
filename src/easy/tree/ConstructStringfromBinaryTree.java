package easy.tree;


/**
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * 
 * @author wenhanglei
 */
public class ConstructStringfromBinaryTree {
	/*
	 * 思路：先序遍历即可
	 */
	public String tree2str(TreeNode t) {
		if(t == null) return "";
		StringBuilder sb = new StringBuilder();
		preOrder(t, sb);
		return sb.toString();
	}
	
	private void preOrder(TreeNode n, StringBuilder sb){
		if(n == null) return;
		sb.append(n.val);
		if(n.left == null && n.right == null);
		else sb.append("(");
		preOrder(n.left, sb);
		if(n.left == null && n.right == null);
		else sb.append(")");
		if(n.right != null) sb.append("(");
		preOrder(n.right, sb);
		if(n.right != null) sb.append(")");
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ConstructStringfromBinaryTree sol = new ConstructStringfromBinaryTree();
		int[] arr = {1, 2, 3, 4};
		TreeNode tree = TreeUtils.getTree(arr);
		String ret = sol.tree2str(tree);
		System.out.println(ret);
	}
}
