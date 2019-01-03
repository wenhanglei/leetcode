package medium.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * @author wenhanglei
 */
public class PalindromePartitioning {
	/*
	 * 思路： 回溯法即可解决
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		List<String> list = new ArrayList<>();
		help(s, 0, ret, list);
		return ret;
	}
	
	private void help(String s, int lo, List<List<String>> ret, List<String> list){
		if(lo == s.length()){
			ret.add(new ArrayList<>(list));
		}
		for(int i = lo; i < s.length(); i++){
			if(isPalindrome(s, lo, i)){
				list.add(s.substring(lo, i+1));
				help(s, i+1, ret, list);
				list.remove(list.size()-1);
			}
		}
	}
	
	private boolean isPalindrome(String s, int lo, int hi){
		while(lo < hi){
			if(s.charAt(lo) != s.charAt(hi)) return false;
			lo++;
			hi--;
		}
		return true;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PalindromePartitioning sol = new PalindromePartitioning();
		List<List<String>> ret = sol.partition("aab");
		System.out.println(ret);
	}
}
