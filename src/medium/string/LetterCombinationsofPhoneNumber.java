package medium.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * @author wenhanglei
 */
public class LetterCombinationsofPhoneNumber {
	/*
	 * 思路：回溯法遍历所有可能的结果并保存即可
	 */
	public List<String> letterCombinations(String digits) {
		//边界检查
		List<String> list = new LinkedList<>();
		if(digits == null || digits.length() == 0) return list;
		String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		help(strs, digits.toCharArray(), 0, "", list);
		return list;
	}
	
	public void help(String[] chs, char[] str, int idx, String word, List<String> list){
		if(idx == str.length){
			list.add(word);
			return;
		}
		String words = chs[str[idx]-'2'];
		for(char ch : words.toCharArray()){
			help(chs, str, idx+1, word+ch, list);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LetterCombinationsofPhoneNumber sol = new LetterCombinationsofPhoneNumber();
		List<String> ret = sol.letterCombinations("");
		System.out.println(ret);
	}
}
