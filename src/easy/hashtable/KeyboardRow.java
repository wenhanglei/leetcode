package easy.hashtable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a List of words, return the words that can 
 * be typed using letters of alphabet on only one row's of American keyboard
 * @author wenhanglei
 */
public class KeyboardRow {
	/*
	 * 思路：
	 */
	public String[] findWords(String[] words) {
		String[] keyRow = {"qwertyuiop", "asdfghjkl","zxcvbnm"};
		//结果变量
		LinkedList<String> retList = new LinkedList<>();
		for(int i = 0; i < words.length; i++){
			boolean isKeyRowWord = true;
			int row = getRowNum(keyRow, words[i].charAt(0));
			for(int j = 0; j < words[i].length(); j++){
				if(row != getRowNum(keyRow, words[i].charAt(j)))
					isKeyRowWord = false;
			}
			if(isKeyRowWord) retList.add(words[i]);
		}
        String[] ret = new String[retList.size()];
        for(int i = 0; i< ret.length; i++)
        	ret[i] = retList.pollFirst();
        return ret;
    }
	
	private int getRowNum(String[] keyRow, char ch){
		for(int i = 0; i < keyRow.length; i++){
			if(keyRow[i].contains(Character.toLowerCase(ch)+"")) return i;
		}
		return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		KeyboardRow sol = new KeyboardRow();
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] ret = sol.findWords(words);
		System.out.println(Arrays.toString(ret));
	}
}
