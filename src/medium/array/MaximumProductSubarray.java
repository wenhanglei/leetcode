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
		int posPre = nums[0] > 0? nums[0]: 0, negPre = nums[0] < 0? nums[0]: 0;
		int max = posPre;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > 0){
				posPre = posPre == 0? nums[i]: posPre*nums[i];
				negPre = negPre == 0? 0: negPre*nums[i];
			}else if(nums[i] < 0){
				int temp = posPre;
				posPre = negPre == 0? 0: negPre*nums[i];
				negPre = temp == 0? nums[i]: temp*nums[i];
			}else {
				posPre = 0;
				negPre = 0;
			}
			max = Math.max(max, posPre);
		}
		return max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {-4, -3, -2};
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int ret = sol.maxProduct(nums);
		System.out.println(ret);
	}
}
