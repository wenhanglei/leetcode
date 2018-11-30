package medium.array;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length. Do not allocate
 * extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * @author wenhanglei
 */
public class RemoveDuplicatesfromSortedArrayII {
	/*
	 * 思路：使用快慢指针保存下一个存放位置的下标即可
	 */
	public int removeDuplicates(int[] nums) {
		if(nums.length < 2) return nums.length;
		int idx = 2; //下一个合法的数可放置的下标
		for(int i = 2; i < nums.length; i++)
			if(nums[i] != nums[idx-2]) nums[idx++] = nums[i];
		return idx;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,2,2,3};
		RemoveDuplicatesfromSortedArrayII sol = new RemoveDuplicatesfromSortedArrayII();
		int ret = sol.removeDuplicates(nums);
		System.out.println(ret);
		System.out.println(Arrays.toString(nums));
	}
}
