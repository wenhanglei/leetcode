package easy.array;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
 * such that each row, column, and both diagonals all have the same sum.
 * 
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?
 * (Each subgrid is contiguous).
 * 
 * @author wenhanglei
 */
public class MagicSquaresInGrid {
	/*
	 * 思路：遍历整个网格判断是否合法
	 */
	public int numMagicSquaresInside(int[][] grid) {
		//边界检查
		if(grid == null) return -1;
		int cnt = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(1 <= grid[i][j] && grid[i][j] <= 9)
					if(isValid(grid, i, j)) cnt++;
			}
		}
		return cnt;
	}
	
	private boolean isValid(int[][] grid, int x, int y){
		if(x+2 >= grid.length || y+2 >= grid[x].length) return false;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++)
				if(!(grid[x+i][y+j] >= 1 && grid[x+i][y+j] <= 9)) return false;
		}
		int sum = grid[x][y] + grid[x][y+1]+grid[x][y+2];
		if((grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2] != sum) ||
				(grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2] != sum) ||
				(grid[x][y] + grid[x+1][y] + grid[x+2][y] != sum) ||
				(grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1] != sum) ||
				(grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2] != sum) ||
				(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != sum) ||
				(grid[x+2][y] + grid[x+1][y+1] + grid[x][y+2] != sum))
			return false;
		return true;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MagicSquaresInGrid sol = new MagicSquaresInGrid();
		int[][] grid = {
				{9, 0, 8, 1, 6},
				{2, 4, 3, 5, 7},
				{4, 3, 4, 9, 2},
				{2, 4, 5, 6, 1},
				{9, 8, 0, 7, 8}
		};
		int ret = sol.numMagicSquaresInside(grid);
		System.out.println(ret);
	}
}
