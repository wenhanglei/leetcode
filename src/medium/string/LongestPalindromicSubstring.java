package medium.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * @author wenhanglei
 *
 */
public class LongestPalindromicSubstring {
	//最大回文子串的起始下标
	private int lo;
	//最大回文子串的最大长度
	private int maxLen;
	/*
	 * 思路：遍历字符串逐个检查获取能构成的最大回文子串
	 */
	public String longestPalindrome(String s) {
		//边界检查
		if(s.length() < 2) return s;
		for(int i = 0; i < s.length(); i++){
			//以下标i为中点构造长度为奇数的回文串
			constructLPS(s, i, i);
			//以下标i和i+1为中间构造长度为偶数的回文串
			constructLPS(s, i, i+1);
		}
		return s.substring(lo, lo+maxLen);
	}
	
	private void constructLPS(String s, int i, int j){
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
			i--;
			j++;
		}
		if(maxLen < j-i-1){
			lo = i+1;
			maxLen = j-i-1;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		String ret = sol.longestPalindrome("cbbd");
		System.out.println(ret);
	}
}
