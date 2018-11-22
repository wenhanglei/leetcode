package medium.array;

/**
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author wenhanglei
 */
public class MinimumPathSum {
	/*
	 * 思路：用递归实现动态规划
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] pathLens = new int[m][n];
		return traverse(grid, pathLens, m, n);
	}
	
	private int traverse(int[][] grid, int[][] pathLens, int m, int n){
		if(pathLens[m-1][n-1] != 0) return pathLens[m-1][n-1];
		if(m == 1 && n == 1) pathLens[m-1][n-1] =  grid[m-1][n-1];
		else if(m == 1) pathLens[m-1][n-1] = traverse(grid, pathLens, m, n-1)+grid[m-1][n-1];
		else if(n == 1) pathLens[m-1][n-1] =  traverse(grid, pathLens, m-1, n)+grid[m-1][n-1];
		else pathLens[m-1][n-1] = Math.min(traverse(grid, pathLens, m-1, n), traverse(grid, pathLens, m, n-1))+grid[m-1][n-1];
		return pathLens[m-1][n-1];
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[][] grid = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		MinimumPathSum sol = new MinimumPathSum();
		int ret = sol.minPathSum(grid);
		System.out.println(ret);
	}
}
