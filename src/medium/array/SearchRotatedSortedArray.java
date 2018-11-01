package medium.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author wenhanglei
 */
public class SearchRotatedSortedArray {
	/*
	 * 思路：先使用二分查找找到最小值的下标，则可求得回环的值。
	 * 使用该回环值修正二分查找，即可解决
	 */
	public int search(int[] nums, int target) {
		//边界检查
		if(nums == null || nums.length == 0)
			return -1;
		int lo = 0, hi = nums.length-1;
		//使用二分查找定位最小值的索引
		while(lo < hi){
			int mid = lo + (hi-lo)/2;
			if(nums[mid] > nums[hi]) lo = mid+1;
			else hi = mid;
		}
		//回环的索引值
		int rot = lo;
		lo = 0;
		hi = nums.length-1;
		//修正二分查找
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			int realMid = (mid + rot) % nums.length;
			if(nums[realMid] == target) return realMid;
			else if(nums[realMid] < target) lo = mid + 1;
			else hi = mid - 1;
		}
		return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SearchRotatedSortedArray sol = new SearchRotatedSortedArray();
		int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
		int ret = sol.search(nums, 0);
		System.out.println(ret);
	}
}
