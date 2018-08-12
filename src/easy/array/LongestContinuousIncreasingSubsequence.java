package easy.array;

/**
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray).
 * 
 * @author wenhanglei
 */
public class LongestContinuousIncreasingSubsequence {
	/*
	 * 思路：普通的遍历即可
	 */
	public int findLengthOfLCIS(int[] nums) {
		//边界检查
		if(nums.length <= 1) return nums.length;
		int max = Integer.MIN_VALUE, count = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] <= nums[i-1]){
				max = Math.max(max, count);
				count = 1;
			}else count++;
		}
		return Math.max(max, count);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence sol = new LongestContinuousIncreasingSubsequence();
		int[] arr = {2, 2};
		int[] arr1 = {1, 3, 5, 4, 7};
		int[] arr2 = {2, 1, 2, 1};
		int ret = sol.findLengthOfLCIS(arr2);
		System.out.println(ret);
	}
}
