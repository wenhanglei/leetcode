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
	/*
	 * 思路：
	 * 分别确定上下界即可
	 */
	public int findUnsortedSubarray(int[] nums) {
		//边界检查
		if(nums == null || nums.length <= 1) return 0;
		int begin = 0, end = 0, max = 0, min = nums.length-1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= nums[max]) max = i;
			else end = i;
			if(nums[nums.length-i-1] <= nums[min]) min = nums.length-i-1;
			else begin = nums.length-i-1;
		}
		if(end > begin) return end-begin+1;
		else return 0;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray sol = new ShortestUnsortedContinuousSubarray();
		int ret = sol.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
		System.out.println(ret);
	}
}
