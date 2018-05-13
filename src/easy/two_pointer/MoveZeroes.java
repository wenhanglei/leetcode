package easy.two_pointer;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to 
 * the end of it while maintaining the relative order of the 
 * non-zero elements.
 * @author wenhanglei
 */
public class MoveZeroes {
	/*
	 * 思路：
	 */
	public void moveZeroes(int[] nums) {
		for(int i = 0, j = 0; i < nums.length; i++){
			if(nums[i] == 0){
				for(j = i;j < nums.length-1 && nums[j] == 0; j++);
				swap(nums, i, j);
			}
		}
    }
	
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {4,2,4,0,0,3,0,5,1,0};
		MoveZeroes sol = new MoveZeroes();
		sol.moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
}
