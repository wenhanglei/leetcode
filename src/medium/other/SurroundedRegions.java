package medium.other;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in
 * that surrounded region.
 * 
 * @author wenhanglei
 */
public class SurroundedRegions {
	/*
	 * 思路：遍历整个二维数组将不能修改的O标记出来
	 */
	public void solve(char[][] board) {
		//边界检查
		if(board == null || board.length == 0) return;
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] marked = new boolean[rows][cols];
		//遍历第一行
		for(int i = 0; i < cols; i++){
			if(!marked[0][i]){
				if(board[0][i] == 'O'){
					helper(board, marked, 0, i, cols, rows);
				}
			}
		}
		//遍历最后一列
		for(int i = 0; i < rows; i++){
			if(!marked[i][cols-1]){
				if(board[i][cols-1] == 'O'){
					helper(board, marked, i, cols-1, cols, rows);
				}
			}
		}
		
		//遍历最后一行
		for(int i = 0; i < cols; i++){
			if(!marked[rows-1][i]){
				if(board[rows-1][i] == 'O'){
					helper(board, marked, rows-1, i, cols, rows);
				}
			}
		}
		
		//遍历第一列
		for(int i = 0; i < rows; i++){
			if(!marked[i][0]){
				if(board[i][0] == 'O'){
					helper(board, marked, i, 0, cols, rows);
				}
			}
		}
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(!marked[i][j]){
					if(board[i][j] == 'O') board[i][j] = 'X';
				}
			}
		}
		
	}
	
	private void helper(char[][] board, boolean[][] marked, int x, int y, int cols, int rows){
		if(x < 0 || x >= rows || y < 0 || y >= cols || marked[x][y] || board[x][y] == 'X') return;
		marked[x][y] = true;
		helper(board, marked, x+1, y, cols, rows);
		helper(board, marked, x, y+1, cols, rows);
		helper(board, marked, x-1, y, cols, rows);
		helper(board, marked, x, y-1, cols, rows);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		char[][] board = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
		};
		SurroundedRegions sol = new SurroundedRegions();
		sol.solve(board);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
