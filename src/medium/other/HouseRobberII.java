package medium.other;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night. Given a list of non-negative integers representing the amount
 * of money of each house, determine the maximum amount of money you can rob
 * tonight without alerting the police.
 * 
 * @author wenhanglei
 */
public class HouseRobberII {
	/*
	 * 思路：使用动态规划解决
	 */
	public int rob(int[] nums) {
		//边界检查
		if(nums.length == 1) return nums[0];
		int sumToPre = 0;         //以当前数前一个数结尾的最大和
		int sumToPrepre = 0;      //以当前数前两个数结尾的最大和
		for(int i = 0; i < nums.length; i++){
			sumToPrepre += nums[i];
			int temp = sumToPre;
			sumToPre = sumToPrepre;
			sumToPrepre = temp;
		}
		if(nums.length%2 != 0) {
			sumToPre -= Math.min(nums[0], nums[nums.length-1]);
		}
		return Math.max(sumToPre, sumToPrepre);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		HouseRobberII sol = new HouseRobberII();
		int ret = sol.rob(new int[]{2, 3, 2});
		System.out.println(ret);
	}
}
