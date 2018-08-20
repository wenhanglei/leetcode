package easy.array;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * @author wenhanglei
 */
public class DegreeOf1Array {
	/*
	 * 思路：使用hashmap统计所以数字的出现次数
	 */
	public int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], map.containsKey(nums[i])?map.get(nums[i])+1:1);
		}
		int max = 0;
		for (int i : map.values()) {
			max = Math.max(max, i);
		}
		int ret = Integer.MAX_VALUE;
		for (Entry<Integer, Integer> ent : map.entrySet()) {
			if(ent.getValue() == max){
				ret = Math.min(ret, lengthOf(nums, ent.getKey()));
			}
		}
		return ret;
	}
	
	private int lengthOf(int[] nums, int i){
		int begin = -1, end = nums.length;
		while(nums[++begin] != i);
		while(nums[--end] != i);
		return end-begin+1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DegreeOf1Array sol = new DegreeOf1Array();
		int[] arr = {1, 2, 2, 3, 1, 4, 2};
		int ret = sol.findShortestSubArray(arr);
		System.out.println(ret);
	}
}
