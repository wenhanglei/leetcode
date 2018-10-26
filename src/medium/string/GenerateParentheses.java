package medium.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * @author wenhanglei
 */
public class GenerateParentheses {
	/*
	 * 思路： 回溯法
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new LinkedList<>();
		help(list, n, 0, "");
		return list;
	}
	
	private void help(List<String> list, int rn, int ln, String str){
		if(rn == 0 && ln == 0){
			list.add(str);
		}else{
			if(rn != 0) help(list, rn-1, ln+1, str+"(");
			if(ln != 0) help(list, rn, ln-1, str+")");
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		GenerateParentheses sol = new GenerateParentheses();
		List<String> ret = sol.generateParenthesis(3);
		System.out.println(ret);
	}
}
