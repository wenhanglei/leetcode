package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * @author wenhanglei
 */
public class SpiralMatrix {
	/*
	 * 思路：修改数组下标即可
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<>();
		//边界检查
		if(matrix == null || matrix.length == 0) return ret;
		//定义移动方向：0向右，1向下，2向左，3向上
		int[][] direcs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		step(ret, matrix, matrix.length, matrix[0].length, 0, -1, direcs, 0);
		return ret;
	}

	private void step(List<Integer> list, int[][] matrix, int m, int n, int x, int y,
			int[][] direcs, int d) {
		if(m == 0 || n == 0) return;
		if(d == 0 || d == 2){
			for(int i = 0; i < n; i++){
				x += direcs[d][0];
				y += direcs[d][1];
				list.add(matrix[x][y]);
			}
			step(list, matrix, m-1, n, x, y, direcs, (d+1)%4);
		}else{
			for(int i = 0; i < m; i++){
				x += direcs[d][0];
				y += direcs[d][1];
				list.add(matrix[x][y]);
			}
			step(list, matrix, m, n-1, x, y, direcs, (d+1)%4);
		}
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] matrix = {{} };
		SpiralMatrix sol = new SpiralMatrix();
		List<Integer> ret = sol.spiralOrder(matrix);
		System.out.println(ret);
	}
}
