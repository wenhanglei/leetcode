package medium.array;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * @author wenhanglei
 */
public class SpiralMatrixII {
	/*
	 * 思路：循环遍历即可
	 */
	public int[][] generateMatrix(int n) {
		//边界检查
		if(n < 1) return null;
		int[][] ret = new int[n][n];
		int i = 1;
		int rows = n, cols = n;
		int x = 0, y = 0;
		while(true){
			if(cols > 0 && rows != 0){
				int ceiling = i+cols;
				while(i < ceiling) ret[x][y++] = i++;
				rows--;
				y--;
				x++;
			}
			if(rows > 0 && cols != 0){
				int ceiling = i+rows;
				while(i < ceiling) ret[x++][y] = i++;
				cols--;
				x--;
				y--;
			}
			if(cols > 0 && rows != 0){
				int ceiling = i+cols;
				while(i < ceiling) ret[x][y--] = i++;
				rows--;
				y++;
				x--;
			}
			if(rows > 0 && cols != 0){
				int ceiling = i+rows;
				while(i < ceiling) ret[x--][y] = i++;
				cols--;
				x++;
				y++;
			}
			if(rows == 0 || cols == 0) break;
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SpiralMatrixII sol = new SpiralMatrixII();
		int[][] ret = sol.generateMatrix(4);
		for (int[] is : ret) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
