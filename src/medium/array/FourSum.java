package medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * @author wenhanglei
 */
public class FourSum {
	/*
	 * 思路：排序后遍历查找即可
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		//边界检查
		List<List<Integer>> list = new LinkedList<>();
		int len = nums.length;
		if(nums == null || len == 0) return list;
		Arrays.sort(nums);
		for(int i = 0; i < len-3; i++){
			if((nums[i] + nums[i+1] + nums[i+2] + nums[i+3]) > target) return list;
			if((nums[i] + nums[len-1] + nums[len-2] + nums[len-3]) < target) continue;
			if(i > 0 && nums[i-1] == nums[i]) continue;
			for(int j=i+1; j<nums.length-2; j++){
				if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break; 
				if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)continue; 
				if(j>i+1&&nums[j]==nums[j-1])continue; 
				int low=j+1, high=nums.length-1;
				while(low<high){
					int sum=nums[i]+nums[j]+nums[low]+nums[high];
					if(sum==target){
						list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while(low<high&&nums[low]==nums[low+1])low++; 
						while(low<high&&nums[high]==nums[high-1])high--; 
						low++; 
						high--;
					}
					else if(sum<target)low++; 
					else high--;
				}
			}
		}
		return list;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FourSum sol = new FourSum();
		List<List<Integer>> ret = sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		System.out.println(ret);
	}
}
