package medium.other;

/**
 * 
 Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * @author wenhanglei
 */
public class KthLargestElementinanArray {
	/*
	 * 思路：分治法解决即可
	 */
	public int findKthLargest(int[] nums, int k) {
		partision(nums, 0, nums.length-1, k-1);
		return nums[k-1];
	}
	
	private void partision(int[] nums, int lo, int hi, int k){
		if(lo >= hi) return;
		int pos = helper(nums, lo, hi);
		if(pos == k) return;
		else if(pos < k) partision(nums, pos+1, hi, k);
		else partision(nums, lo, pos-1, k);
	}
	
	private int helper(int[] nums, int lo, int hi){
		int i = lo, j = hi+1;
		while(true){
			while(nums[++i] >= nums[lo]) if(i == hi) break;
			while(nums[--j] < nums[lo]) if(j == lo) break;
			if(i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, lo, j);
		return j;
	}
	
	private void swap(int[] nums, int i, int j){
		if(i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		KthLargestElementinanArray sol = new KthLargestElementinanArray();
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int ret = sol.findKthLargest(nums, 4);
		System.out.println(ret);
	}
}
