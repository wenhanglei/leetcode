package medium.other;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * @author wenhanglei
 */
public class WordBreak {
	/*
	 * 思路：遍历检查即可
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s.isEmpty()) return true;
		for(String str : wordDict){
			if(s.startsWith(str)){
				if(wordBreak(s.substring(str.length()), wordDict))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
//		String s = "catsandog";
		String s = "leetcode";
		String[] dict = {"leet", "code"};
//		String[] dict = {"cats", "dog", "sand", "and", "cat"};
		List<String> wordDict = Arrays.asList(dict);
		WordBreak sol = new WordBreak();
		boolean ret = sol.wordBreak(s, wordDict);
		System.out.println(ret);
	}
}
