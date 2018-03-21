package easy.array;
/**
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest sum.
 * @author wenhanglei
 */
public class MaximumSubarray {
	/*
	 * 思路：
	 * 动态规划
	 * 求数组中连续子向量的最大和
	 */
	
	/**
	 * 动态规划解法
	 */
	public int maxSubArray(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		int max = nums[0];            //上一个状态的最大的子向量之和
		int res = max;                //结果变量
		for(int i = 1; i < nums.length; i++){
			max = (max > 0?max:0) + nums[i];
			res = Math.max(max, res);
		}
		return res;
	}
	
	/**
	 * 返回nums[0:i]中以nums[i]结尾的最大子向量
	 */
	private int maxSubArray(int[] nums, int i){
		if(i == 0) return nums[0];
		return maxSubArray(nums, i-1) > 0?maxSubArray(nums, i-1):0 + nums[i];
	}
	
	/**
	 * 简单朴素的解法
	 */
//	public int maxSubArray(int[] nums) {
//		//边界检查
//		if(nums == null || nums.length == 0) return 0;
//		int sum = 0, max = 0, min = 0, res = nums[0];
//		for(int i = 0; i < nums.length; i++){
//			sum += nums[i];
//			if(sum >= max || sum-min > res){
//				max = sum;
//				res = max-min;
//			}
//			if(sum < min)
//				min = sum;
//		}
//        return res;
//    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {-2, 1};
		MaximumSubarray sol = new MaximumSubarray();
		int res = sol.maxSubArray(arr);
		System.out.println(res);
	}
}
