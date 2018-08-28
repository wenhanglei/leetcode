package easy.hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string.
 * 
 * @author wenhanglei
 */
public class LongestWordInDictionary {
	
	/*
	 * 思路：
	 * 方案一：字典树（有点小复杂，本题就不用了）
	 * 方案二：排序，保存所有合法的字符串
	 */
	public String longestWord(String[] words) {
		Arrays.sort(words);
		HashSet<String> set = new HashSet<>();
		String ret = "";
		for (String str : words) {
			if(str.length() == 1 || set.contains(str.substring(0, str.length()-1))){
				ret = str.length() > ret.length() ? str: ret;
				set.add(str);
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestWordInDictionary sol = new LongestWordInDictionary();
		String ret = sol.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
		System.out.println(ret);
	}
}
