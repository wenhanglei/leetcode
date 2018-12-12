package medium.tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * @author wenhanglei
 */
public class UniqueBinarySearchTrees {
	/*
	 * 思路：与求所有的二叉排序树的算法类似
	 */
	public int numTrees(int n) {
		if(n <= 1) return n==1?1:0;
		int[] nums = new int[n+1];
		nums[1] = 1;
		for(int i = 2; i <= n; i++){
			int num = 0;
			for(int j = 1; j <= i; j++){
				int left = nums[j-1];
				int right = nums[i-j];
				left = left == 0?1:left;
				right = right == 0?1:right;
				num += left * right;
			}
			nums[i] = num;
		}
		return nums[n];
	}
	
	private int helper(int lo, int hi){
		if(lo > hi) return 0;
		
		int num = 0;
		int left = 0;
		int right = 0;
		
		for(int i = lo; i <= hi; i++){
			left = helper(lo, i-1);
			right = helper(i+1, hi);
			
			left = left == 0?1:left;
			right = right == 0?1:right;
			
			num += left*right;
		}
		
		return num;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
		int ret = sol.numTrees(3);
		System.out.println(ret);
	}
}
