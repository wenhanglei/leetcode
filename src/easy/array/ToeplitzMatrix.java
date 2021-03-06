package easy.array;

import java.util.LinkedList;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * 
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * 
 * @author wenhanglei
 */
public class ToeplitzMatrix {
	/*
	 * 思路：
	 * 方案一：使用双端队列保存数据
	 * 方案二：遍历检查即可
	 */
	public boolean isToeplitzMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length-1; i++){
			for(int j = 0; j < matrix[i].length-1; j++){
					if(matrix[i][j] != matrix[i+1][j+1]) return false;
			}
		}
		return true;
	}
//	public boolean isToeplitzMatrix(int[][] matrix) {
//		LinkedList<Integer> list = new LinkedList<>();
//		for(int i = 0; i < matrix[0].length; i++){
//			list.addLast(matrix[0][i]);
//		}
//		int j = 1;
//		while(j < matrix.length){
//			list.removeLast();
//			int i = 0;
//			list.addFirst(matrix[j][i]);
//			for (Integer k : list) {
//				if(k != matrix[j][i++]) return false;
//			}
//			j++;
//		}
//		return true;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ToeplitzMatrix sol = new ToeplitzMatrix();
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 1, 2, 3},
				{9, 5, 1, 2}
		};
		boolean ret = sol.isToeplitzMatrix(matrix);
		System.out.println(ret);
	}
}
