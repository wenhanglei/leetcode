package medium.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * @author wenhanglei
 */
public class LargestNumber {
	/*
	 * 思路：一般的排序实现即可
	 */
	public String largestNumber(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return "";
		
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) strs[i] = Integer.toString(nums[i]);
		
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s2.compareTo(s1);
			}
		};
		
		Arrays.sort(strs, cmp);
		
		if(strs[0].equals("0")) return "0";
		
		StringBuilder sb = new StringBuilder();
		for(String str: strs){
			sb.append(str);
		}
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		LargestNumber sol = new LargestNumber();
		String ret = sol.largestNumber(nums);
		System.out.println(ret);
	}
}
