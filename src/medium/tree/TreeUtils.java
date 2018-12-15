package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树工具类
 * @author wenhanglei
 */
public class TreeUtils {
	
	/**
	 * 根据传递的整型数组生成相应的二叉树并返回根节点
	 * 空节点用'#'表示
	 */
	public static TreeNode getTree(int[] arr){
		if(arr == null || arr.length == 0) return null;
		return getTree(arr, 0);
	}
	
	private static TreeNode getTree(int[] arr, int i){
		if(i >= arr.length || arr[i] == '#') return null;
		TreeNode node = new TreeNode(arr[i]);
		node.left = getTree(arr, 2*i+1);
		node.right = getTree(arr, 2*i+2);
		return node;
	}
	
	/**
	 * 根据传递的二叉树的根节点生成对应的数组返回
	 */
	public static Object[] getArray(TreeNode root){
		ArrayList<String> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == null) {
				res.add(null); continue;
			}
			res.add(""+node.val);
			if(node.left == null && node.right == null) continue;
			if(node.left != null)
				queue.offer(node.left);
			else queue.offer(null);
			if(node.right != null)
				queue.offer(node.right);
			else queue.offer(null);
		}
		return res.toArray();
	}
}
