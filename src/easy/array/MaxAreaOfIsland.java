package easy.array;


/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * @author wenhanglei
 *
 */
public class MaxAreaOfIsland {
	
	private boolean[][] marked;
	private int count = 0;
	private int max = 0;
	/*
	 * 思路：深度优先遍历
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		marked = new boolean[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(!marked[i][j]) {
					DFS(grid, i, j);
					max = Math.max(max, count);
					count = 0;
				}
			}
		}
		return max;
	}
	
	private void DFS(int[][] grid, int i, int j){
		if(!marked[i][j] && grid[i][j] == 1){
			count++;
			marked[i][j] = true;
			if(valid(grid, i+1, j)) DFS(grid, i+1, j);
			if(valid(grid, i-1, j)) DFS(grid, i-1, j);
			if(valid(grid, i, j+1)) DFS(grid, i, j+1);
			if(valid(grid, i, j-1)) DFS(grid, i, j-1);
		}
	}
	
	private boolean valid(int[][] grid, int i, int j){
		if(i >= 0 && i <= grid.length-1 && j >= 0 && j <= grid[0].length-1)
			return true;
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MaxAreaOfIsland sol = new MaxAreaOfIsland();
		int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		int ret = sol.maxAreaOfIsland(arr);
		System.out.println(ret);
	}
}
