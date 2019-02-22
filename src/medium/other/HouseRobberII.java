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
	 * 思路：使用动态规划解决，个数为奇数和偶数分别处理
	 */
	public int rob(int[] nums) {
		// 边界检查
		if (nums.length == 1)
			return nums[0];
		int oddSum = 0;
		int sinSum = 0;
		if (nums.length % 2 == 0) {
			for (int i = 0; i < nums.length; i++) {
				if (i % 2 == 0)
					oddSum += nums[i];
				else
					sinSum += nums[i];
			}
			return Math.max(oddSum, sinSum);
		} else {
			for (int i = 0; i < nums.length - 1; i++) {
				if (i % 2 == 0)
					oddSum += nums[i];
				else
					sinSum += nums[i];
			}
			sinSum = Math.max(
					(sinSum - nums[nums.length - 2] + nums[nums.length - 1]),
					sinSum);
			return Math.max(sinSum, oddSum);
		}
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		HouseRobberII sol = new HouseRobberII();
		int ret = sol.rob(new int[] { 1, 3, 1, 3, 100 });
		System.out.println(ret);
	}
}
