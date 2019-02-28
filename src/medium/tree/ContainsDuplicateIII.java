package medium.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * @author wenhanglei
 */
public class ContainsDuplicateIII {
	/*
	 * 思路：使用桶划分判断是否合法
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		//边界检查
		if(t < 0) return false;
		if(t == 0){
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < nums.length; i++){
				if(!set.add(nums[i])) return true;
				if(set.size() == k+1) set.remove(nums[i-k]);
			}
			return false;
		}
		//使用hashmap作为桶集合保存不重复的结果集
		HashMap<Long, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			long j = ((long)nums[i]-Integer.MIN_VALUE)/t;
			if(map.containsKey(j)){
				return true;
			}else if(map.containsKey(j-1)){
				if(Math.abs(map.get(j-1)-(long)nums[i]) <= t) return true;
			}else if(map.containsKey(j+1)){
				if(Math.abs(map.get(j+1)-(long)nums[i]) <= t) return true;
			}
			map.put(j, nums[i]);
			if(map.size() == k+1){
				map.remove(((long)nums[i-k]-Integer.MIN_VALUE)/t);
			}
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ContainsDuplicateIII sol = new ContainsDuplicateIII();
		int[] nums = {-1, 2147483647};
		boolean ret = sol.containsNearbyAlmostDuplicate(nums, 2, 2147483647);
		System.out.println(ret);
	}
}
