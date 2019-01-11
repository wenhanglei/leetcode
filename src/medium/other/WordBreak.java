package medium.other;

import java.util.Arrays;
import java.util.HashSet;
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
	 * 思路：使用动态规划
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		//先将字典保存到set中方便后面检查
		HashSet<String> set = new HashSet<>(wordDict);
		//创建可达性数组保存每个下标的可达性
		boolean[] marked = new boolean[s.length()+1];
		marked[0] = true;
		for(int i = 1; i <= s.length(); i++){
			for(int j = 0; j < i; j++){
				if(marked[j] && set.contains(s.substring(j, i))){
					marked[i] = true;
					break;
				}
			}
		}
		return marked[s.length()];
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
