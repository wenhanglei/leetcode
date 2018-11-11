package medium.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * @author wenhanglei
 */
public class PermutationsII {
	/*
	 * 思路：我真是写的狗屎
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		//边界检查
		if(nums == null || nums.length == 0) return ret;
		traverse(ret, nums, 0);
		return ret;
	}

	private void traverse(List<List<Integer>> ret, int[] nums, int idx) {
		if(idx == nums.length-1){
			List<Integer> list = new LinkedList<>();
			for(int i : nums) list.add(i);
			ret.add(list);
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = idx; i < nums.length; i++){
			if(set.add(nums[i])){
				swap(nums, idx, i);
				traverse(ret, nums, idx+1);
				swap(nums, idx, i);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j){
		if(i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PermutationsII sol = new PermutationsII();
		List<List<Integer>> ret = sol.permuteUnique(new int[] {1, 1, 2});
		System.out.println(ret);
	}
}
