package easy.math;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the
 * x, y, and z axes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * 
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2
 * dimensional plane.
 * 
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the
 * front, and the side.
 * 
 * Return the total area of all three projections.
 * 
 * @author wenhanglei
 */
public class ProjectionAreaOf3DShapes {
	/*
	 * 思路：xy面的投影是所有的数字的个数
	 * 	   xz面的投影是所有y值固定的z值中的最大值
	 *     yz面的投影是所有x值固定的z值的最大值
	 */
	public int projectionArea(int[][] grid) {
		int[] mZ = new int[grid.length], mY = new int[grid.length];
		int count = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] != 0) {
					count++;
					mZ[i] = Math.max(grid[i][j], mZ[i]);
					mY[j] = Math.max(grid[i][j], mY[j]);
				}
			}
		}
		for(int i : mZ) count += i;
		for(int i : mY) count += i;
		return count;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ProjectionAreaOf3DShapes sol = new ProjectionAreaOf3DShapes();
		int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
		int ret = sol.projectionArea(grid);
		System.out.println(ret);
	}
}
