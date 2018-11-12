package medium.array;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * @author wenhanglei
 */
public class RotateImage {
	/*
	 * 思路：先上下翻转，在根据对角线翻转即可
	 */
	public void rotate(int[][] matrix) {
		//边界检查
		if(matrix == null || matrix.length < 2) return;
		int len = matrix.length;
		//上下翻转
		for(int row = 0; row < len/2; row++){
			for(int col = 0; col < matrix[row].length; col++){
				swap(matrix, row, col, len-row-1, col);
			}
		}
		//对角线翻转
		for(int row = 0; row < len; row++){
			for(int col = row + 1; col < matrix[row].length; col++){
				swap(matrix, row, col, col, row);
			}
		}
	}
	
	private void swap(int[][] matrix, int i, int j, int x, int y){
		if(i == x && j == y) return;
		int temp = matrix[i][j];
		matrix[i][j] = matrix[x][y];
		matrix[x][y] = temp;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RotateImage sol = new RotateImage();
		int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		sol.rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
