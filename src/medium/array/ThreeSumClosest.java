package medium.array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * @author wenhanglei
 */
public class ThreeSumClosest {
	/*
	 * 思路：与求和为指定值的方法类似
	 */
	public int threeSumClosest(int[] nums, int target) {
		//对数组排序
		Arrays.sort(nums);
		//结果变量
		Integer ret = null;
		//遍历数组
		for(int i = 0; i < nums.length-2; i++){
			if(i == 0 || nums[i-1] != nums[i]){
				int rem = target - nums[i];
				int lo = i+1, hi = nums.length-1;
				while(lo < hi){
					int sum = nums[lo] + nums[hi];
					if(ret == null || Math.abs(rem-sum) < Math.abs(target-ret)) ret = nums[i]+sum;
					if(sum <= rem) while(lo < hi && nums[++lo] == nums[lo-1]);
					if(sum >= rem) while(lo < hi && nums[--hi] == nums[hi+1]);
				}
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ThreeSumClosest sol = new ThreeSumClosest();
		int[] nums = {-1, 2, 1, -4};     //结果为2
		int[] nums1 = {1, 1, 1, 0};      //结果为
		int[] nums2 = {0, 2, 1, -3};     //结果为0
		int ret = sol.threeSumClosest(nums, 1);
		System.out.println(ret);
	}
}
