package medium.array;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 * 
 * @author wenhanglei
 *
 */
public class SetMatrixZeroes {
	/*
	 * 思路： 遍历查找0，记录行列坐标即可
	 */
	public void setZeroes(int[][] matrix) {
		//边界检查
		if(matrix == null || matrix.length == 0) return;
		int m = matrix.length, n = matrix[0].length;
		boolean[] row = new boolean[m], col = new boolean[n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i = 0; i < m; i++){
			if(row[i])
				for(int j = 0; j < n; j++) matrix[i][j] = 0;
		}
		for(int i = 0; i < n; i++){
			if(col[i])
				for(int j = 0; j < m; j++) matrix[j][i] = 0;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}
		};
		SetMatrixZeroes sol = new SetMatrixZeroes();
		sol.setZeroes(matrix);
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
