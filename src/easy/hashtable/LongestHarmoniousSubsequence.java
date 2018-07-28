package easy.hashtable;

import java.util.HashMap;

/**
 * We define a harmonious array is an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * 
 * @author wenhanglei
 */
public class LongestHarmoniousSubsequence {
	/*
	 * 思路：统计所有相同的值最后求相邻键的值之和
	 */
	public int findLHS(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
			map.put(nums[i], map.containsKey(nums[i])?map.get(nums[i])+1:1);
		int max = 0;
		for(int i : map.keySet()){
			if(map.containsKey(i+1)){
				max = Math.max(max, map.get(i)+map.get(i+1));
			}
		}
		return max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestHarmoniousSubsequence sol = new LongestHarmoniousSubsequence();
		int ret = sol.findLHS(new int[]{2});
		System.out.println(ret);
	}
}
