package medium.array;

import java.rmi.server.UID;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * @author wenhanglei
 */
public class UniquePathsII {
	/*
	 * 思路：有障碍的与无障碍的逻辑大概一致，多一步初始化
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] steps = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				steps[i][j] = obstacleGrid[i][j]==1?0:-1;
			}
		}
		traverse(m, n, steps);
		return steps[m-1][n-1];
	}
	
	private int traverse(int m, int n, int[][] steps){
		if(steps[m-1][n-1] != -1) return steps[m-1][n-1];
		else {
			if(m == 1 && n == 1) steps[m-1][n-1] = 1;
			else if(m == 1) steps[m-1][n-1] = traverse(m, n-1, steps);
			else if(n == 1) steps[m-1][n-1] = traverse(m-1, n, steps);
			else steps[m-1][n-1] = traverse(m-1, n, steps) + traverse(m, n-1, steps);
			return steps[m-1][n-1];
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UniquePathsII sol = new UniquePathsII();
		int[][] obs = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		int ret = sol.uniquePathsWithObstacles(obs);
		System.out.println(ret);
	}
}
