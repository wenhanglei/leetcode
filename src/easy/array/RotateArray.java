package easy.array;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * @author wenhanglei
 */
public class RotateArray {
	/*
	 * 思路：
	 * 
	 */
	//方法一
	//使用辅助数组
	public void rotate(int[] nums, int k) {
		int len = nums.length;
        int[] as = new int[len];
        for(int i = 0; i < len; i++) {
        	as[(i+k)%len] = nums[i];
        }
        for(int i = 0; i < len; i++) {
        	nums[i] = as[i];
        }
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		RotateArray sol = new RotateArray();
		sol.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
}
