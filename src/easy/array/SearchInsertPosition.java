package easy.array;
/**
 * Given a sorted array and a target value, return 
 * the index if the target is found. If not, return 
 * the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @author wenhanglei
 */
public class SearchInsertPosition {
	/*
	 * 思路：
	 * 二分查找
	 */
	public int searchInsert(int[] nums, int target) {
		if(nums.length == 0 || nums == null) return -1;
        return binarySearch(nums, 0, nums.length-1, target);
    }
	
	/**
	 * 二分查找的递归实现
	 */
	private int binarySearch(int[] nums, int lo, int hi, int target){
		if(lo > hi) return lo;
		int mid = lo + (hi-lo)/2;
		if(nums[mid] < target){
			return binarySearch(nums, mid+1, hi, target);
		}else if(nums[mid] > target){
			return binarySearch(nums, lo, mid-1, target);
		}else return mid;
	}
	
	/**
	 * 二分查找的循环实现
	 */
//	private int binarySearch(int[] nums, int lo, int hi, int target){
//		while(lo <= hi){
//			int mid = lo + (hi-lo)/2;
//			if(nums[mid] < target){
//				lo = mid+1;
//			}else if(nums[mid] > target){
//				hi = mid-1;
//			}else return mid;
//		}
//		return lo;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 6};
		SearchInsertPosition sol = new SearchInsertPosition();
		int searchInsert = sol.searchInsert(arr1, 5);
		System.out.println(searchInsert);
	}
}
