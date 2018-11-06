package medium.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * @author wenhanglei
 */
public class CombinationSum {
	/*
	 * 思路：回溯法求得所有可能的结果集合，最后去重即可。
	 * update:前面一种方案时间复杂度太高，需要改进。可以先对数组进行排序然后不回头地回溯，可以直接避免重复结果集
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new LinkedList<>();
		//边界检查
		if(candidates == null || candidates.length == 0) return ret;
		Arrays.sort(candidates);
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < candidates.length; i++)
			traverse(candidates, ret, stack, i, target, 0);
		return ret;
	}
	
	private void traverse(int[] candidates, List<List<Integer>> list, Stack<Integer> stack, int lo, int target, int sum){
		//如果当前路劲所有数字和等于目标数字，则将栈中的结果添加到结果集中
		stack.push(candidates[lo]);
		sum += candidates[lo];
		if(sum == target) {
			list.add(new LinkedList<>(stack));
		}else if(sum < target){
			for(;lo < candidates.length; lo++){
				traverse(candidates, list, stack, lo, target, sum);
			}
		}
		stack.pop();
	}
	
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//		List<List<Integer>> ret = new LinkedList<>();
//		//边界检查
//		if(candidates == null || candidates.length == 0) return ret;
//		help(candidates, ret, 0, target, "");
//		removeDuplicate(ret);
//		return ret;
//	}
	
	private void help(int[] candidates, List<List<Integer>> list, int sum, int target, String nums){
		if(sum == target){
			String[] ns = nums.split(",");
			List<Integer> l = new LinkedList<>();
			for(String str : ns){
				if(!str.equals("")) l.add(Integer.valueOf(str));
			}
			list.add(l);
			return;
		}else if(sum > target) return;
		for(int i = 0; i < candidates.length; i++){
			help(candidates, list, sum+candidates[i], target, nums + candidates[i] + ",");
		}
	}
	
	private void removeDuplicate(List<List<Integer>> list){
		HashSet<String> set = new HashSet<>();
		List<List<Integer>> candicates = new LinkedList<>();
		for(int i = 0; i < list.size(); i++){
			StringBuilder sb = new StringBuilder();
			List<Integer> l = list.get(i);
			Collections.sort(l);
			for(int j : l){
				sb.append(j+"");
			}
			if(!set.add(sb.toString())) candicates.add(l);
		}
		for(List<Integer> l : candicates) list.remove(l);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CombinationSum sol = new CombinationSum();
		int[] candidates = {2, 3, 6, 7};
		List<List<Integer>> ret = sol.combinationSum(candidates, 7);
		System.out.println(ret);
	}
}
