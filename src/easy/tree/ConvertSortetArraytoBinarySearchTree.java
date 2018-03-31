package easy.tree;
/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author wenhanglei
 */
public class ConvertSortetArraytoBinarySearchTree {
	/*
	 * 思路：
	 * 递归
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		//检查边界
		if(nums == null || nums.length == 0) return null;
        return toBST(nums, 0, nums.length);
    }
	
	private TreeNode toBST(int[] nums, int lo, int hi){
		if(lo >= hi) return null;
		int mid = lo + (hi-lo)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = toBST(nums, lo, mid);
		node.right = toBST(nums, mid+1, hi);
		return node;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {-10, -3, 0, 5, 9};
		ConvertSortetArraytoBinarySearchTree sol = new ConvertSortetArraytoBinarySearchTree();
		TreeNode res = sol.sortedArrayToBST(arr);
		System.out.println(res);
	}
}
