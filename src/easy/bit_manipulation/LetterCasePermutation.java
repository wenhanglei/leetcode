package easy.bit_manipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string. Return a list of all possible strings
 * we could create.
 * 
 * @author wenhanglei
 */
public class LetterCasePermutation {
	/*
	 * 思路 ：递归实现
	 */
	public List<String> letterCasePermutation(String S) {
		List<String> list = new LinkedList<>();
		//边界检查
		if(S == null) return list;
		help(S.toCharArray(), 0, "", list);
		return list;
	}
	
	private void help(char[] chs, int i, String str, List<String> list){
		if(i == chs.length){
			list.add(str);
			return;
		}
		help(chs, i+1, str+chs[i], list);
		if('a' <= chs[i] && chs[i] <= 'z'){
			help(chs, i+1, str+Character.toUpperCase(chs[i]), list);
		}else if('A' <= chs[i] && chs[i] <= 'Z'){
			help(chs, i+1, str+Character.toLowerCase(chs[i]), list);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LetterCasePermutation sol = new LetterCasePermutation();
		List<String> ret = sol.letterCasePermutation("a1b2");
		System.out.println(ret);
	}
}
