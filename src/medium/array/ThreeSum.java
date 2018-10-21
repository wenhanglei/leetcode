package medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * @author wenhanglei
 */
public class ThreeSum {
	/*
	 * 思路：先对整个数组排序在使用双指针依次查找即可
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		//边界检查
		List<List<Integer>> ret = new LinkedList<>();
		if(nums == null || nums.length <= 0)
			return ret;
		//对数组排序
		Arrays.sort(nums);
		//遍历整个数组
		for(int i = 0; i < nums.length-2; i++){
			if(i == 0 || nums[i-1] != nums[i]){
				int lo = i+1, hi = nums.length-1, rem = -nums[i];
				while(lo < hi){
					int sum = nums[lo] + nums[hi];
					if(sum == rem){
						List<Integer> list = new  LinkedList<>();
						list.add(nums[i]);
						list.add(nums[lo]);
						list.add(nums[hi]);
						ret.add(list);
					}
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
		ThreeSum sol = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums1 = {-2, 0, 0, 2, 2};
		List<List<Integer>> ret = sol.threeSum(nums);
		System.out.println(ret);
	}
}
