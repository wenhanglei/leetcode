package easy.dynamic_programming;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author wenhanglei
 */
public class ClimbingStairs {
	/*
	 * 思路：
	 * 动态规划
	 */
	public int climbStairs(int n) {
		//检查边界
		if(n <= 2) return n;
		//创建辅助数组
		int[] ass = new int[n+1];
		ass[1] = 1;
		ass[2] = 2;
		return climb(n, ass);
    }
	
	private int climb(int n, int[] ass){
		if(n <= 2) return n;
		//判断辅助数组是否已经有值了，如果有值则返回辅助数组的值
		if(ass[n] != 0) return ass[n];
		//如果只爬一层，则有climbStairs(n-1)种爬法
		int num = climb(n-1, ass);
		//如果爬两层，则有climbStairs(n-2)种爬法
		num += climb(n-2, ass);
		ass[n] = num;
		return num;
	}
	
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ClimbingStairs sol = new ClimbingStairs();
		int res = sol.climbStairs(10);
		System.out.println(res);
	}
}
