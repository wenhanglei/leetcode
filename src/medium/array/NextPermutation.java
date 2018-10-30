package medium.array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * @author wenhanglei
 */
public class NextPermutation {
	/*
	 * 思路：求下一个全排列
	 * 1： 从后向前扫描查找到第一个非递增的数的下标
	 * 2：从后向前扫描找到第一个大于非递增数的数的下标
	 * 3：交换数组中的两个数
	 * 4：将刚才保存的后半截递增数组反向排列即为结果
	 */
	public void nextPermutation(int[] nums) {
		//边界检查
		if(nums.length == 1) return;
		int preIdx;
		preIdx = findSmaller(nums);
		if(preIdx != -1) {
			int proIdx = findBigger(nums, preIdx); 
			swap(nums, preIdx, proIdx);
		}
		reverseSort(nums, preIdx+1);
	}
	
	private int findSmaller(int[] nums){
		int index = nums.length-1;
		while(index > 0 && nums[--index] >= nums[index+1]);
		return (nums[index] >= nums[index+1])?-1:index;
	}
	
	private int findBigger(int[] nums, int preIdx){
		for(int i = nums.length-1; i > preIdx; i--){
			if(nums[i] > nums[preIdx]) return i;
		}
		return -1;
	}
	
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void reverseSort(int[] nums, int lo){
		int hi = nums.length-1;
		while(lo < hi){
			int temp = nums[lo];
			nums[lo++] = nums[hi];
			nums[hi--] = temp;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NextPermutation sol = new NextPermutation();
		int[] nums = {1};
		sol.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(nums));
	}
}
