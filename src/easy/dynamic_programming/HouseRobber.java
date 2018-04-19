package easy.dynamic_programming;
/**
 * You are a professional robber planning to rob 
 * houses along a street. Each house has a certain 
 * amount of money stashed, the only constraint stopping 
 * you from robbing each of them is that adjacent houses 
 * have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken 
 * into on the same night.
 * @author wenhanglei
 */
public class HouseRobber {
	/*
	 * 思路：
	 */
	public int rob(int[] nums) {
		//边界检查
		if(nums == null || nums.length == 0) return 0;
		int maxSoFar = 0;                   //到第i-2家为止最抢劫的最大值
		int maxI = nums[0];                 //第i家比抢的能获得的最大值
		for(int i = 1; i < nums.length; i++) {
			int temp = maxI;
			maxI = maxSoFar + nums[i];
			if(temp > maxSoFar)
				maxSoFar = temp;
		}
		return Math.max(maxI, maxSoFar);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {2, 1, 1, 2};
		HouseRobber sol = new HouseRobber();
		int res = sol.rob(nums);
		System.out.println(res);
	}
}
