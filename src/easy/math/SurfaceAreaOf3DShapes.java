package easy.math;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
 * 
 * @author wenhanglei
 */
public class SurfaceAreaOf3DShapes {
	/*
	 * 思路：每一个立柱的面积为4*v+2，如果旁边有一个相邻的立柱则构成的新的形状需要减去被遮挡
	 * 的面积
	 */
	public int surfaceArea(int[][] grid) {
		int ret = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] != 0){
					ret += 4*grid[i][j] + 2;
					if(i > 0) ret -= Math.min(grid[i-1][j], grid[i][j])*2;
					if(j > 0) ret -= Math.min(grid[i][j-1], grid[i][j])*2;
				}
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SurfaceAreaOf3DShapes sol = new SurfaceAreaOf3DShapes();
		int[][] grid = {
				{2, 2, 2},
				{2, 1, 2},
				{2, 2, 2}
		};
		int ret = sol.surfaceArea(grid);
		System.out.println(ret);
	}
}
