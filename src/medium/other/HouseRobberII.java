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
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return Math.max(rob(nums, 0, nums.length-2),rob(nums, 1, nums.length-1));
	}
	
	//指定上下界求能抢劫的最大和
	private int rob(int[] nums, int lo, int hi){
		int maxSoFar = 0;
		int maxI = nums[lo];
		for(int i = lo+1; i <= hi; i++){
			int temp = maxI;
			maxI = maxSoFar + nums[i];
			if(temp > maxSoFar)
				maxSoFar = temp;
		}
		return Math.max(maxSoFar, maxI);
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
