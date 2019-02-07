package medium.other;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * @author wenhanglei
 */
public class NumberOfIslands {
	/*
	 * 思路：遍历整个数组统计遇到的小岛
	 */
	public int numIslands(char[][] grid) {
		//边界检查
		if(grid == null || grid.length == 0) return 0;
		int rows = grid.length, cols = grid[0].length;
		boolean[][] marked = new boolean[rows][cols];
		int count = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(grid[i][j] == '1' && !marked[i][j]){
					helper(grid, marked, i, j, cols, rows);
					count++;
				}
			}
		}
		return count;
	}
	
	private void helper(char[][] grid, boolean[][] marked, int x, int y, int cols, int rows){
		if(x < 0 || x >= rows || y < 0 || y >= cols || marked[x][y] || grid[x][y] == '0') return;
		marked[x][y] = true;
		helper(grid, marked, x-1, y, cols, rows);
		helper(grid, marked, x+1, y, cols, rows);
		helper(grid, marked, x, y-1, cols, rows);
		helper(grid, marked, x, y+1, cols, rows);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'},
		};
		NumberOfIslands sol = new NumberOfIslands();
		int ret = sol.numIslands(grid);
		System.out.println(ret);
	}
}
