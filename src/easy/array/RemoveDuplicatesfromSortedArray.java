package easy.array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates 
 * in-place such that each element appear only 
 * once and return the new length.
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * @author wenhanglei
 */
public class RemoveDuplicatesfromSortedArray {
	/*
	 * 思路：
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		int index = 0, val = 0, next = 0;
		while(next < nums.length){
			val = nums[next];
			while(next < nums.length && nums[next] == val)
				next++;
			nums[index++] = val;
		}
		return index;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2, 3, 4, 4};
		RemoveDuplicatesfromSortedArray sol = new RemoveDuplicatesfromSortedArray();
		int res = sol.removeDuplicates(arr);
		System.out.println(res);
		System.out.println(Arrays.toString(arr));
	}
}
