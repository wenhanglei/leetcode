package easy.array;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can
 * reshape a matrix into a new one with different size but keep its original
 * data. You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively. The reshaped matrix need to be
 * filled with all the elements of the original matrix in the same
 * row-traversing order as they were. If the 'reshape' operation with given
 * parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 * 
 * @author wenhanglei
 *
 */
public class ReshapeMatrix {
	/*
	 * 思路
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		//边界检查
		if(nums == null) return null;
		int or = nums.length, oc = nums[0].length;
		if(or * oc != r * c) return nums;
		int[][] ret = new int[r][c];
		for(int i = 0; i < r*c; i++){
			ret[i/c][i%c] = nums[i/oc][i%oc];
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[][] nums = {{1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12}};
		ReshapeMatrix sol = new ReshapeMatrix();
		sol.matrixReshape(nums, 4, 3);
	}
}
