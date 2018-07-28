package easy.math;

/**
 * Given an m * n matrix M initialized with all 0's and several update
 * operations.
 * 
 * Operations are represented by a 2D array, and each operation is represented
 * by an array with two positive integers a and b, which means M[i][j] should be
 * added by one for all 0 <= i < a and 0 <= j < b.
 * 
 * You need to count and return the number of maximum integers in the matrix
 * after performing all the operations.
 * 
 * @author wenhanglei
 */
public class RangeAdditionII {
	/*
	 * 思路：简单地遍历记录即可
	 */
	public int maxCount(int m, int n, int[][] ops) {
		//边界检查
		if(ops.length == 0) return m*n;
		//横坐标的最小值和纵坐标的最小值
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		//遍历所有的坐标
		for(int i = 0; i < ops.length; i++){
			if(ops[i][0] < minX) minX = ops[i][0];
			if(ops[i][1] < minY) minY = ops[i][1];
		}
		return minX*minY;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RangeAdditionII sol = new RangeAdditionII();
		int ret = sol.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}});
		System.out.println(ret);
	}
}
