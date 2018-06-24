package easy.hashtable;
/**
 * You are given a map in form of a two-dimensional 
 * integer grid where 1 represents land and 0 represents 
 * water. Grid cells are connected horizontally/vertically 
 * (not diagonally). The grid is completely surrounded by 
 * water, and there is exactly one island (i.e., one or more 
 * connected land cells). The island doesn't have "lakes" 
 * (water inside that isn't connected to the water around 
 * the island). One cell is a square with side length 1. 
 * The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.
 * @author wenhanglei
 */
public class IslandPerimeter {
	/*
	 * 思路：
	 * 从左上角开始遍历
	 */
	public int islandPerimeter(int[][] grid) {
		int count = 0, overlaps = 0;                  //为1的个数和重复的计数
		for(int i = 0; i < grid.length; i++){         //第i行
			for(int j = 0; j < grid[i].length; j++){  //第j列
				if(grid[i][j]==1){                    //如果这个数是小岛
					count++;
					//向下统计重复计算的个数
					if(i < grid.length-1 && grid[i+1][j]==1) overlaps++;
					//向右统计重复计算的个数
					if(j < grid[i].length-1 && grid[i][j+1]==1) overlaps++;
				}
			}
		}
        return count*4-overlaps*2;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		IslandPerimeter sol = new IslandPerimeter();
		int[][] grid = {
				{0, 1, 0, 0},
				{1, 1, 1, 0},
				{0, 1, 0, 0},
				{1, 1, 0, 0}
		};
		int ret = sol.islandPerimeter(grid);
		System.out.println(ret);
	}
}
