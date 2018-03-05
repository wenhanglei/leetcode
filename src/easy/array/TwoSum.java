package easy.array;

import java.util.HashMap;

/**
 * Given an array of integers,
 * return indices of the two numbers 
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * @author wenhanglei
 */
public class TwoSum {
	/*
	 * 思路：
	 * map存放已经检查过的数，用空间换时间
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target-nums[i])){
				ret[1] = i;
				ret[0] = map.get(target-nums[i]);
			}
			map.put(nums[i], i);
		}
		return ret;
    }
	
}
