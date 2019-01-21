package medium.array;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * @author wenhanglei
 */
public class MaximumProductSubarray {
	/*
	 * 思路： 与求最小和向量的思路是一样的
	 */
	public int maxProduct(int[] nums) {
		//边界检查
		if(nums.length == 1) return nums[0];
		int pre = nums[0], max = Integer.MIN_VALUE;
		for(int i = 1; i < nums.length; i++){
			pre = pre == 0? nums[i]: nums[i]*pre;
			max = Math.max(pre, max);
		}
		return max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {3, -1, 4};
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int ret = sol.maxProduct(nums);
		System.out.println(ret);
	}
}
