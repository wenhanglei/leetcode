package easy.sort;
/**
 * Given two strings s and t, write a function to 
 * determine if t is an anagram of s.
 * @author wenhanglei
 */
public class ValidAnagram {
	/*
	 * 思路：
	 */
	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
