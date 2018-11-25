package medium.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * @author wenhanglei
 */
public class Search2DMatrix {
	/*
	 * 思路：这不就是分块查找嘛
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		//边界检查
		if(matrix == null || matrix.length == 0) return false;
		int lo = 0, hi = matrix.length-1;
		while(lo < hi){
			int mid = lo + (hi-lo+1)/2;
			if(lo == mid) break;
			if(matrix[mid][0] == target) return true;
			else if(matrix[mid][0] > target) hi = mid-1;
			else lo = mid;
		}
		int r = hi;
		lo = 0;
		hi = matrix[r].length-1;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			if(matrix[r][mid] == target) return true;
			else if(matrix[r][mid] < target) lo = mid + 1;
			else hi = mid - 1;
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		  int[][] matrix = {
				  {1, 3, 5, 7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
		  };
		  int[][] mat = {
				  {1, 3}
		  };
		  Search2DMatrix sol = new Search2DMatrix();
		  boolean ret = sol.searchMatrix(matrix, 13);
		  System.out.println(ret);
	}
}
