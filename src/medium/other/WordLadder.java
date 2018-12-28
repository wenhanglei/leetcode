package medium.other;

import java.util.Arrays;
import java.util.List;

import utils.ArrayUtil;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * @author wenhanglei
 */
public class WordLadder {
	int min = Integer.MAX_VALUE;
	/*
	 * 思路： 广度优先遍历
	 */
	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		int m = wordList.size();
		for(int i = 0; i < m; i++){
			boolean[] marked = new boolean[m];
			if(beginWord.equals(wordList.get(i))) {
				marked[i] = true;
				continue;
			}
			if(isValid(wordList.get(i), beginWord)) helper(endWord, i, wordList, marked, 2);
		}
		return min == Integer.MAX_VALUE?0:min;
	}
	
	private void helper(String endWord, int idx, List<String> wl, boolean[] marked, int cnt){
		if(endWord.equals(wl.get(idx))) {
			min = Math.min(min, cnt);
			return;
		}
		marked[idx] = true;
		for(int i = 0; i < marked.length; i++){
			if(!marked[i]){
				String str = wl.get(idx);
				String word = wl.get(i);
				if(isValid(str, word)) helper(endWord, i, wl, marked, cnt+1);
			}
		}
	}
	
	private boolean isValid(String str, String word){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)-word.charAt(i) != 0) count++;
		}
		return count == 1?true:false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
		WordLadder sol = new WordLadder();
		int ret = sol.ladderLength(beginWord, endWord, wordList);
		System.out.println(ret);
	}
}
