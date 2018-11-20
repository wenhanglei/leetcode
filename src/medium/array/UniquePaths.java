package medium.array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author wenhanglei
 */
public class UniquePaths {
	/*
	 * 思路：动态规划啦
	 */
	public int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		uniquePaths(m, n, matrix);
		return matrix[m-1][n-1];
	}
	
	private int uniquePaths(int m, int n, int[][] matrix){
		if(matrix[m-1][n-1] != 0) return matrix[m-1][n-1];
		else if(m == 1 || n == 1) {
			matrix[m-1][n-1] = 1;
			return 1;
		}else{
			matrix[m-1][n-1] =  uniquePaths(m-1, n, matrix)+uniquePaths(m, n-1, matrix);
			return matrix[m-1][n-1];
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UniquePaths sol = new UniquePaths();
		int ret = sol.uniquePaths(7, 3);
		System.out.println(ret);
	}
}
