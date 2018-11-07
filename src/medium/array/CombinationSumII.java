package medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * @author wenhanglei
 */
public class CombinationSumII {
	/*
	 * 思路：跟第一种解法类似，但是必须考虑去重问题
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new LinkedList<>();
		if(candidates == null || candidates.length == 0) return ret;
		Arrays.sort(candidates);
		List<Integer> list = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		traverse(candidates, 0, target, 0, ret, list, set);
		for(int i = 1; i < candidates.length; i++){
			if(candidates[i] != candidates[i-1])
				traverse(candidates, i, target, 0, ret, list, set);
		}
		return ret;
	}
	
	private void traverse(int[] candidates, int lo, int target, int sum, List<List<Integer>> ret, List<Integer> list, HashSet<String> set){
		list.add(candidates[lo]);
		sum += candidates[lo];
		if(sum == target) {
			if(set.add(list.toString()))
				ret.add(new LinkedList<>(list));
		}
		else if(sum < target){
			for(lo++; lo < candidates.length; lo++){
				if(sum+candidates[lo] > target) break;
				traverse(candidates, lo, target, sum, ret, list, set);
			}
		}
		list.remove(list.size()-1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CombinationSumII sol = new CombinationSumII();
		int[] candidates = {2,5,2,1,2};
		List<List<Integer>> ret = sol.combinationSum2(candidates, 5);
		System.out.println(ret);
	}
}
