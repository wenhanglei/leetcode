package easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * @author wenhanglei
 */
public class SetMismatch {
	/*
	 *  思路：使用hashmap即可
	 */
	public int[] findErrorNums(int[] nums) {
		//边界检查
		int[] ret = new int[2];
		if(nums.length < 2) return ret;
		for(int i = 0, j = 0; i < nums.length; i++){
			j = nums[i] > 0?nums[i]:-nums[i];
			if(nums[j-1] < 0) ret[0] = j;
			else nums[j-1] = -nums[j-1];
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0) {
			 ret[1] = i+1;
			 break;
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SetMismatch sol = new SetMismatch();
		int[] ret = sol.findErrorNums(new int[]{1, 2, 2, 4});
		System.out.println(Arrays.toString(ret));
	}
}
