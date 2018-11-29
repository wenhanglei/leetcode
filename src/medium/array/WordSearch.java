package medium.array;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * @author wenhanglei
 */
public class WordSearch {
	/*
	 * 思路：递归检查即可
	 */
	public boolean exist(char[][] board, String word) {
		//边界检查
		if(word == null || word.length() == 0) return false;
		int row = board.length, col = board[0].length;
		boolean[][] marked = new boolean[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(scan(board, marked, i, j, word.toCharArray(), 0)) return true;
			}
		}
		return false;
	}
	
	private boolean scan(char[][] board, boolean[][] marked, int i, int j, char[] chs, int idx){
		if(idx == chs.length) return true;
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || marked[i][j]) return false;
		if(board[i][j] == chs[idx]){
			marked[i][j] = true;
			boolean ret =  scan(board, marked, i+1, j, chs, idx+1)
			|| scan(board, marked, i-1, j, chs, idx+1)
			|| scan(board, marked, i, j+1, chs, idx+1)
			|| scan(board, marked, i, j-1, chs, idx+1);
			marked[i][j] = false;
			return ret;
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		char[][] board = {
		  {'A','B','C','E'},
		  {'S','F','C','S'},
		  {'A','D','E','E'}
		};
		WordSearch sol = new WordSearch();
		boolean ret = sol.exist(board, "ABCB");
		System.out.println(ret);
	}
}
