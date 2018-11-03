package medium.array;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * @author wenhanglei
 */
public class Find1stLastPositionElementSortedArray {
	/*
	 * 思路： 二分查找的变体形式
	 * 1. 求得排序数组中大于或等于目标值的第一个值的索引
	 */
	public int[] searchRange(int[] nums, int target) {
		//边界检查
		int start = firstGreaterOrEqual(nums, target);
		if(start == nums.length || nums[start] != target) return new int[]{-1, -1};
		return new int[]{start, firstGreaterOrEqual(nums, target+1)-1};
	}
	
	/**
	 * 查找排序数组中的大于等于给定值的第一个数的下标
	 * @param nums 升序排序数组
	 * @param target 给定值
	 * @return
	 */
	private int firstGreaterOrEqual(int[] nums, int target){
		//边界检查
		if(nums == null || nums.length == 0) return nums.length;
		int lo = 0, hi = nums.length;
		while(lo < hi){
			int mid = lo + ((hi-lo)>>1);
			if(nums[mid] < target) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Find1stLastPositionElementSortedArray sol = new Find1stLastPositionElementSortedArray();
		int[] ret = sol.searchRange(new int[]{1}, 1);
		System.out.println(Arrays.toString(ret));
	}
}
