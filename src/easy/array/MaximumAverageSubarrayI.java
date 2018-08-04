package easy.array;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * @author wenhanglei
 */
public class MaximumAverageSubarrayI {
	/*
	 * 思路：遍历即可
	 */
	public double findMaxAverage(int[] nums, int k) {
		//边界检查
		int begin = 0, end = 0;
		double sum = 0;
		for(; end < k; end++)
			sum += nums[end];
		double max = sum;
		for(; end < nums.length; end++, begin++){
			sum = sum-nums[begin]+nums[end];
			if(sum > max) max = sum;
		}
		return max/k;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();
		double ret = sol.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
		System.out.println(ret);
	}
}
