package easy.hashtable;

import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase 
 * letters, find the length of the longest palindromes that 
 * can be built with those letters.
 * @author wenhanglei
 */
public class LongestPalindrome {
	/*
	 * 思路：
	 * 遍历整个字符串出现一对的时候计数加一并重新统计
	 */
	public int longestPalindrome(String s) {
		//边界判断
		if(s == null || s.length() == 0) return 0;
		HashSet<Character> set = new HashSet<>();
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(set.contains(c)){
				set.remove(c);
				count++;
			}else{
				set.add(c);
			}
		}
		return set.isEmpty()?count*2:count*2+1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestPalindrome sol = new LongestPalindrome();
		int ret = sol.longestPalindrome("abccccdd");
		System.out.println(ret);
	}
}
