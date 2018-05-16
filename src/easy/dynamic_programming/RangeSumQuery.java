package easy.dynamic_programming;
/**
 * Given an integer array nums, find the sum of the elements 
 * between indices i and j (i ≤ j), inclusive.
 * @author wenhanglei
 */
public class RangeSumQuery {
	
	/*
	 * 思路：辅助数组
	 */
	private int[] sums;
	
	public RangeSumQuery(int[] nums) {
		sums = new int[nums.length];
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			sums[i] = sum;
		}
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return sums[j];
        else return sums[j] - sums[i-1];
    }
    
    /**
     * 测试函数
     */
    public static void main(String[] args) {
		int[] arr = {-2, 0, 3, -5, 2, -1};
		RangeSumQuery sol = new RangeSumQuery(arr);
		int ret = sol.sumRange(0, 5);
		System.out.println(ret);
	}
}
