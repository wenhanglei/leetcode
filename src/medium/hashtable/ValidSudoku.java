package medium.hashtable;

import java.util.HashSet;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 	1. Each row must contain the digits 1-9 without repetition.
 *  2. Each column must contain the digits 1-9 without repetition.
 *  3.Each of the 9 3x3 sub-boxes of the grid must contain the 
 *  digits 1-9 without repetition.
 * 
 * @author wenhanglei
 */
public class ValidSudoku {
	/*
	 * 思路：使用字符串编码行信息，列信息，方格信息保存到hashset中。
	 * 遍历二维数组，如果出现重复信息则不合法
	 */
	public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[i].length; j++){
        		char num = board[i][j];
        		if(num != '.'){
        			String str1 = num + " in row " + i;
        			String str2 = num + " in col " + j;
        			String str3 = num + " in block " + i/3 + j/3;
        			if(set.contains(str1) || set.contains(str2) || set.contains(str3)) 
        				return false;
        			set.add(str1);
        			set.add(str2);
        			set.add(str3);
        		}
        	}
        }
        return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
