package easy.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * 
 * @author wenhanglei
 */
public class MaximumDepthN_aryTree {
	
	/*
	 * 思路：
	 * 随便一种遍历即可
	 */
	public int maxDepth(Node root) {
		if(root == null) return 0;
		int max = 0;
		for(Node child : root.children){
			int tem = maxDepth(child);
			if(tem > max)
				max = tem;
		}
		return max+1;
	}
	
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}

}
