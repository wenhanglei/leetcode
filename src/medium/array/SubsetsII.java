package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set). Note: The solution set must not contain
 * duplicate subsets.
 * 
 * @author wenhanglei
 */
public class SubsetsII {
	/*
	 * 思路：先对数组进行排序,回溯法遍历即可
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		//边界检查
		if(nums == null || nums.length == 0) return ret;
		List<Integer> list = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		Arrays.sort(nums);
		help(ret, list, set, nums, -1);
		ret.add(list);
		return ret;
	}
	
	private void help(List<List<Integer>> ret, List<Integer> list, HashSet<String> set, int[] nums, int i){
		for(i++;i < nums.length; i++){
			list.add(nums[i]);
			if(set.add(list.toString()))
				ret.add(new ArrayList<>(list));
			help(ret, list, set, nums, i);
			list.remove(list.size()-1);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		SubsetsII sol = new SubsetsII();
		List<List<Integer>> ret = sol.subsetsWithDup(nums);
		System.out.println(ret);
		
	}
}
