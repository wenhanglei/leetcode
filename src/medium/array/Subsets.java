package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * @author wenhanglei
 *
 */
public class Subsets {
	/*
	 * 思路：先对数组排序在依次遍历，其实可以不用排序的
	 */
	public List<List<Integer>> subsets(int[] nums) {
		//边界检查
		List<List<Integer>> ret = new LinkedList<>();
		if(nums == null || nums.length == 0) return ret;
		//排序
//		Arrays.sort(nums);
		List<Integer> list = new LinkedList<>();
		ret.add(new LinkedList<>(list));
		traverse(nums, 0, ret, list);
		return ret;
	}
	
	private void traverse(int[] nums, int i, List<List<Integer>> ret, List<Integer> list){
		for(int j = i; j < nums.length; j++){
			list.add(nums[j]);
			ret.add(new LinkedList<>(list));
			traverse(nums, j+1, ret, list);
			list.remove(list.size()-1);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Subsets sol = new Subsets();
		List<List<Integer>> ret = sol.subsets(nums);
		System.out.println(ret);
	}
}
