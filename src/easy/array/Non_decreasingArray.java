package easy.array;

/**
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for
 * every i (1 <= i < n).
 * 
 * @author wenhanglei
 */
public class Non_decreasingArray {
	/*
	 * 思路：需要修改数组中的值
	 * 遍历整个数组如果发现第i个数小于第i-1个数这修改第i-1个数值为第i个数的值，计数加一
	 * 如果第i-2个数也小于第i个数则修改第i个数的值为第i-1个数的值
	 */
	public boolean checkPossibility(int[] nums) {
		if(nums == null) return false;
		if(nums.length == 1) return true;
		int cnt = 0;
		for(int i = 1; i < nums.length && cnt <= 1; i++){
			if(nums[i-1] > nums[i]){
				cnt++;
				if(i < 2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
				else nums[i] = nums[i-1];
			}
		}
		return cnt <= 1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Non_decreasingArray sol  = new Non_decreasingArray();
		int[] arr = {1, 2, 3};
		boolean ret = sol.checkPossibility(new int[]{3,4,2,3});
		System.out.println(ret);
	}
}
