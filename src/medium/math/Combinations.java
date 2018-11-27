package medium.math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * @author wenhanglei
 */
public class Combinations {
	/*
	 * 思路：使用set去重
	 */
	public List<List<Integer>> combine(int n, int k) {
		//边界检查
		List<List<Integer>> ret = new LinkedList<>();
		if(k == 0) return ret;
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= n; i++) help(n, k-1, i, ret, set);
		return ret;
	}
	
	private void help(int n, int k, int curr, List<List<Integer>> ret, Set<Integer> set){
		set.add(curr);
		if(k <= 0) ret.add(new LinkedList<>(set));
		else{
			for(int i = curr+1; i <= n; i++)
				help(n, k-1, i, ret, set);
		}
		set.remove(curr);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Combinations sol = new Combinations();
		List<List<Integer>> ret = sol.combine(4, 2);
		System.out.println(ret);
	}
}
