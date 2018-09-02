package easy.dynamic_programming;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * @author wenhanglei
 */
public class MinCostClimbingStairs {
	/*
	 * 思路：动态规划
	 * 方案一：递归实现
	 * 方案二：迭代实现
	 */
	public int minCostClimbingStairs(int[] cost) {
		//结果变量
		int[] min = new int[cost.length];
		for(int i = 0; i < cost.length; i++){
			if(i < 2) {min[i] = 0; continue;}
			min[i] = Math.min(min[i-1]+cost[i-1], min[i-2]+cost[i-2]);
		}
		return Math.min(min[cost.length-1]+cost[cost.length-1], min[cost.length-2]+cost[cost.length-2]);
	}
	
//	public int minCostClimbingStairs(int[] cost) {
//		return func(cost.length, cost);
//	}
//	
//	/**
//	 * 跳到第n步台阶时的最小消耗数值
//	 * @param n
//	 */
//	private int func(int n, int[] cost){
//		if(n < 2) return 0;
//		return Math.min(func(n-1, cost) + cost[n-1], func(n-2, cost) + cost[n-2]);
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MinCostClimbingStairs sol = new MinCostClimbingStairs();
		int ret = sol.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		System.out.println(ret);
	}
}
