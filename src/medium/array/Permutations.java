package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * @author wenhanglei
 */
public class Permutations {
	/*
	 * 思路：回溯法即可
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		//边界检查
		if(nums == null || nums.length == 0) return ret;
		List<Integer> ctn = new LinkedList<>();
		boolean[] marked = new boolean[nums.length];
		for(int i = 0; i < nums.length; i++)
			backTracking(ret, ctn, marked, nums, i, 1);
		return ret;
	}
	
	private void backTracking(List<List<Integer>> list, List<Integer> ctn, boolean[] marked, int[] nums, int idx, int len){
		ctn.add(nums[idx]);
		marked[idx] = true;
		if(len == nums.length) {
			list.add(new LinkedList<>(ctn));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(!marked[i]){
					backTracking(list, ctn, marked, nums, i, len+1);
				}
			}
		}
		marked[idx] = false;
		ctn.remove((Object)nums[idx]);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Permutations sol = new Permutations();
		int[] nums = {1, 2, 3};
		List<List<Integer>> ret = sol.permute(nums);
		System.out.println(ret);
	}
}
