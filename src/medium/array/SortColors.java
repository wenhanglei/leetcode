package medium.array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author wenhanglei
 */
public class SortColors {
	/*
	 * 思路：先使用计数排序弄一下
	 */
	public void sortColors(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return;
		int[] count = new int[4];
		for(int i = 0; i < nums.length; i++) count[nums[i]+1]++;
		for(int i = 1; i < count.length; i++) count[i] += count[i-1];
		for(int i = 0; i < nums.length; i++){
			if(i < count[1]) nums[i] = 0;
			else if(i < count[2]) nums[i] = 1;
			else if(i < count[3]) nums[i] = 2;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SortColors sol = new SortColors();
		int[] nums = {2, 0, 2, 1, 1, 0};
		sol.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
