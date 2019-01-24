package medium.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * @author wenhanglei
 */
public class FindMinimumRotatedSortedArray {
	/*
	 * 思路：二分查找变体即可
	 */
	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length-1;
		if(nums[lo] < nums[hi]) return nums[lo];
		while(lo < hi){
			if(hi == lo+1) break;
			int mid = lo + (hi-lo)/2;
			if(nums[mid] > nums[lo]) lo = mid;
			else hi = mid;
		}
		return nums[hi];
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1,2};
		FindMinimumRotatedSortedArray sol = new FindMinimumRotatedSortedArray();
		int ret = sol.findMin(nums);
		System.out.println(ret);
	}
}
