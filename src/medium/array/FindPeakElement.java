package medium.array;

/**
 * A peak element is an element that is greater than its neighbors. Given an
 * input array nums, where nums[i] ≠ nums[i+1], find a peak element and return
 * its index. The array may contain multiple peaks, in that case return the
 * index to any one of the peaks is fine.
 * 
 * @author wenhanglei
 *
 */
public class FindPeakElement {
	/*
	 * 思路：缩小查找边界直到只剩下最后一个值
	 */
	public int findPeakElement(int[] nums) {
		int lo = 0, hi = nums.length-1;
		while(lo < hi){
			int mid = lo + (hi-lo)/2;
			if(nums[mid] > nums[mid+1]){
				hi = mid;
			}else if(nums[mid] < nums[mid+1]){
				lo = mid+1;
			}
		}
		return lo;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,5,6,4};
		FindPeakElement sol = new FindPeakElement();
		int ret = sol.findPeakElement(nums);
		System.out.println(ret);
	}
}
