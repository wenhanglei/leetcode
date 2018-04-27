package easy.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out 
 * whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 * @author wenhanglei
 */
public class ContainsDuplicateII {
	/*
	 * 思路：
	 * 使用hashset保存k个连续序号的数值
	 * 如果再这k个连续下标的数中存在相同的数则返回true
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			if(i > k) set.remove(nums[i-k-1]);
			if(set.contains(nums[i])) return true;
			else set.add(nums[i]);
		}
        return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
