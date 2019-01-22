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
		int[][] dp = new int[2][nums.length];
		if(nums[0] > 0) dp[0][0] = nums[0];
		else if(nums[0] < 0) dp[1][0] = nums[0];
		int max = dp[0][0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > 0){
				dp[0][i] = dp[0][i-1] == 0? nums[i]: dp[0][i-1]*nums[i];
				dp[1][i] = dp[1][i-1] == 0? 0: dp[1][i-1]*nums[i];
			}else if(nums[i] < 0){
				dp[0][i] = dp[1][i-1] == 0? 0: dp[1][i-1]*nums[i];
				dp[1][i] = dp[0][i-1] == 0? nums[i]: dp[0][i-1]*nums[i];
			}
			max = Math.max(max, dp[0][i]);
		}
		return max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {-4, -3};
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int ret = sol.maxProduct(nums);
		System.out.println(ret);
	}
}
