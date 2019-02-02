package medium.other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * @author wenhanglei
 */
public class LargestNumber {
	/*
	 * 思路：基数排序实现即可
	 */
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) strs[i] = Integer.toString(nums[i]);
		
		
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
