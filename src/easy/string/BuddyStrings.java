package easy.string;

import java.util.HashMap;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 * 
 * @author wenhanglei
 */
public class BuddyStrings {
	/*
	 * 思路：简单朴素的替换比较即可
	 */
	public boolean buddyStrings(String A, String B) {
		if(A == null || B == null || A.length() != B.length()) return false;
		if(A.equals(B)){
			HashMap<Character, Integer> map = new HashMap<>();
			for(char ch : A.toCharArray()){
				map.put(ch, map.containsKey(ch)?map.get(ch)+1:1);
			}
			for(int i : map.values()) if(i > 1) return true;
			return false;
		}
		StringBuilder sb = new StringBuilder(A);
		int i = 0;
		while(sb.charAt(i) == B.charAt(i)) i++;
		int j = i+1;
		while(sb.charAt(j) == B.charAt(j)) j++;
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb.toString().equals(B);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BuddyStrings sol = new BuddyStrings();
		boolean ret = sol.buddyStrings("aaaaaaabc", "aaaaaaacb");
		System.out.println(ret);
	}
}
