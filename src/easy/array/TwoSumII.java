package easy.array;

import java.util.Arrays;

/**
 * Given an array of integers that is already 
 * sorted in ascending order, find two numbers 
 * such that they add up to a specific target number.
 * @author wenhanglei
 */
public class TwoSumII {
	/*
	 * 思路：
	 * 双指针操作
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int lo = 0;
		int hi = numbers.length - 1;
		while(lo <= hi){
			int sum = numbers[lo] + numbers[hi];
			if(sum < target){
				lo++;
			}else if(sum > target){
				hi--;
			}else {
				res[0] = lo+1;
				res[1] = hi+1;
				return res;
			}
		}
        return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] numbers = {2, 7, 9, 11};
		TwoSumII sol = new TwoSumII();
		int[] res = sol.twoSum(numbers, 9);
		System.out.println(Arrays.toString(res));
		
	}
}
