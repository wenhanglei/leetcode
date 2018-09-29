package easy.array;

import java.util.Arrays;

/**
 * Given a matrix A, return the transpose of A.
 * 
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 * 
 * @author wenhanglei
 */
public class TransposeMatrix {
	/*
	 * 思路： 
	 */
	public int[][] transpose(int[][] A) {
		int[][] ret = new int[A[0].length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				ret[j][i] = A[i][j];
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		TransposeMatrix sol = new TransposeMatrix();
		int[][] A = {
				{1, 2, 3},
				{4, 5, 6},
		};
		int[][] ret = sol.transpose(A);
		for(int[] arr : ret){
			System.out.println(Arrays.toString(arr));
		}
	}
}
