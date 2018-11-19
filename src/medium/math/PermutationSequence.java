package medium.math;

import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * @author wenhanglei
 */
public class PermutationSequence {
	/*
	 * 思路：使用数组保存各个值的阶乘，再判断即可
	 */
	public String getPermutation(int n, int k) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		for(int i = 1; i < n; i++) arr[i] = i*arr[i-1];
		List<String> list = new LinkedList<>();
		for(int i = 1; i <= n; i++) list.add(i+"");
		StringBuilder sb = new StringBuilder();
		while(!list.isEmpty()){
			int i = (k-1)/arr[n-1];
			sb.append(list.remove(i));
			k = (k-1)%arr[--n]+1;
		}
		return sb.toString();
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PermutationSequence sol = new PermutationSequence();
		String ret = sol.getPermutation(3, 3);
		System.out.println(ret);
	}
}
