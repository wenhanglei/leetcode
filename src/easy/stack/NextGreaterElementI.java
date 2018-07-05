package easy.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) 
 * nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements 
 * in the corresponding places of nums2.
 * @author wenhanglei
 */
public class NextGreaterElementI {
	/*
	 * 思路：
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//结果变量
		int[] ret = new int[nums1.length];
		//map用于保存每一个数字的下一个最大值
		Map<Integer, Integer> map = new HashMap<>();
		//用于保存当前需要比较的数字
		Stack<Integer> stack = new Stack<>();
		int curr = 0;                        //当前需要比较的nums2中的下标
		while(curr < nums2.length){
			while(!stack.isEmpty() && nums2[curr] > stack.peek())
				map.put(stack.pop(), nums2[curr]);
			stack.push(nums2[curr++]);
		}
		while(!stack.isEmpty())
			map.put(stack.pop(), -1);
		for(int i = 0; i < nums1.length; i++)
			ret[i] = map.get(nums1[i]);
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NextGreaterElementI sol = new NextGreaterElementI();
		int[] nums1 = {2, 4};
		int[] nums2 = {1, 2, 3, 4};
		int[] ret = sol.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(ret));
	}
}
