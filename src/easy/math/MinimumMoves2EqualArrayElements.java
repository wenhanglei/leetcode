package easy.math;
/**
 * Given a non-empty integer array of size n, find 
 * the minimum number of moves required to make all 
 * array elements equal, where a move is incrementing 
 * n - 1 elements by 1.
 * @author wenhanglei
 */
public class MinimumMoves2EqualArrayElements {
	/*
	 * 思路：
	 * 单纯的数学题
	 */
	public int minMoves(int[] nums) {
		
		int minNum = nums[0], sum = 0;            //数组的最小值和数值和
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < minNum) minNum = nums[i];
			sum += nums[i];
		}
		
        return sum-minNum*nums.length;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MinimumMoves2EqualArrayElements sol = new MinimumMoves2EqualArrayElements();
		int[] nums = {1, 3, 3, 7};
		int ret = sol.minMoves(nums);
	}
	
}
