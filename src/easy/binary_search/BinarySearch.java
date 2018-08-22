package easy.binary_search;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 * 
 * @author wenhanglei
 */
public class BinarySearch {
	/*
	 *  思路： 二分查找实现
	 */
	public int search(int[] nums, int target) {
		int low = 0, hi = nums.length-1;
		while(low <= hi){
			int mid = low + (hi-low)/2;
			if(nums[mid] < target){
				low = mid + 1;
			}else if(nums[mid] > target){
				hi = mid - 1;
			}else return mid;
		}
		return -1;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
