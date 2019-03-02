package medium.other;


/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * @author wenhanglei
 */
public class MaximalSquare {
	/*
	 * 思路：使用dp[i][j]保存以i，j为右下角的矩阵的最大方阵的边的长度
	 */
	public int maximalSquare(char[][] matrix) {
		//边界检查
		if(matrix == null || matrix.length == 0) return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = Integer.MIN_VALUE;
		//遍历所有的非第一行和非第一列的元素
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i == 0 || j == 0) dp[i][j] = matrix[i][j]-'0';
				else if(matrix[i][j] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max*max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		MaximalSquare sol = new MaximalSquare();
		int ret = sol.maximalSquare(matrix);
		System.out.println(ret);
	}
}
