package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * @author wenhanglei
 */
public class CombinationSumIII {
	/*
	 * 思路：回溯法并且当前可取的数不能小于当前数
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new LinkedList<>();
		for(int i = 1; i < n && i < 10; i++){
			List<Integer> list = new LinkedList<>();
			helper(k-1, n-i, i, ret, list);
		}
		return ret;
	}
	
	private void helper(int k, int n, int i, List<List<Integer>> ret, List<Integer> list){
		list.add(i);
		if(k == 0 && n == 0) {
			ret.add(new LinkedList<>(list));
		}else if(k != 0 && n != 0) {
			for(int j = i+1; j < n+1 && j < 10; j++){
				helper(k-1, n-j, j, ret, list);
			}
		}
		list.remove(list.size()-1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CombinationSumIII sol = new CombinationSumIII();
		List<List<Integer>> ret = sol.combinationSum3(2, 6);
		System.out.println(ret);
	}
}
