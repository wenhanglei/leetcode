package medium.array;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * @author wenhanglei
 */
public class MinimumSizeSubarraySum {
	/*
	 * 思路：使用双指针
	 */
	public int minSubArrayLen(int s, int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0; 
		int lo = -1, hi = -1, sum = 0, min = 0;
		while(hi < nums.length){
			if(lo == hi){
				hi++;
				if(hi != nums.length) sum += nums[hi];
			}else{
				if(sum >= s){
					if(min == 0) min = hi-lo;
					else min = Math.min(hi-lo, min);
					lo++;
					sum -= nums[lo];
				}else{
					hi++;
					if(hi != nums.length) sum += nums[hi];
				}
			}
		}
		return min;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();
		int[] nums = {2, 3, 1, 2, 4, 3};
		int ret = sol.minSubArrayLen(7, nums);
		System.out.println(ret);
	}
}
