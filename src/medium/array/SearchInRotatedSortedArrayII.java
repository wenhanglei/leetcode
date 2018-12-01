package medium.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * @author wenhanglei
 */
public class SearchInRotatedSortedArrayII {
	/*
	 * 思路：先使用二分查找找到第一个下降的值，然后对回环后的数组进行修正后的二分查找即可
	 */
	public boolean search(int[] nums, int target) {
		//边界检查
		if(nums == null || nums.length == 0) return false;
		//查找回环起始下标
		int rem = 1;
		for(; rem < nums.length; rem++){
			if(nums[rem-1]>nums[rem]) break;
		}
		//对二分查找进行修正
		int lo = 0,hi = nums.length-1;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			int realMid = (mid+rem)%nums.length;
			if(nums[realMid] == target) return true;
			else if(nums[realMid] < target) lo = mid+1;
			else hi = mid-1;
		}
		return false;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {2,2,2,0,2,2};
		SearchInRotatedSortedArrayII sol = new SearchInRotatedSortedArrayII();
		boolean ret = sol.search(nums, 0);
		System.out.println(ret);
	}
}
