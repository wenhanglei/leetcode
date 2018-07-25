package easy.array;

/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * @author wenhanglei
 */
public class ShortestUnsortedContinuousSubarray {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	boolean exist = false;
	/*
	 * 思路：
	 * 对数组进行快速排序取得最大坐标减去最小坐标即为所求结果
	 */
	public int findUnsortedSubarray(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		quickSort(0, nums.length, nums);
		if(exist) return max-min+1;
		else return 0;
	}
	
	private void quickSort(int lo, int hi, int[] nums){
		if(lo >= hi) return;
		int sep = partition(lo, hi, nums);
		if(sep != lo){
			if(!exist) exist = true;
			if(sep > max) max = sep;
			if(lo < min) min = lo;
		}
		quickSort(lo, sep, nums);
		quickSort(sep+1, hi, nums);
	}
	
	/**
	 * 使用较小的下标对数组划分，返回需要移动到的下标
	 */
	private int partition(int lo, int hi, int[] nums){
		if(lo >= hi-1) return lo;
		int i = lo, j = hi;
		while(i < j){
			while(j > lo && nums[--j] > nums[lo]);
			while(i < j && nums[++i] < nums[lo]);
			swap(i, j, nums);
		}
		swap(lo, j, nums);
		return j;
	}
	
	/**
	 * 交换两个下标的值
	 */
	private void swap(int lo, int hi, int[] nums){
		if(lo >= hi) return;
		int temp = nums[lo];
		nums[lo] = nums[hi];
		nums[hi] = temp;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray sol = new ShortestUnsortedContinuousSubarray();
		int ret = sol.findUnsortedSubarray(new int[]{1, 2, 3, 3, 3});
		System.out.println(ret);
	}
}
