package easy.array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n
 * pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of
 * min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * @author wenhanglei
 */
public class ArrayPartitionI {
	/*
	 * 思路：
	 * 排序
	 */
	public int arrayPairSum(int[] nums) {
		//边界检查
		if(nums == null) return 0;
		Arrays.sort(nums);
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			if(i%2==0) sum += nums[i];
		}
		return sum;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ArrayPartitionI sol = new ArrayPartitionI();
		int ret = sol.arrayPairSum(new int[]{1, 4, 3, 2});
		System.out.println(ret);
	}
}
