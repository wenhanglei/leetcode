package easy.stack;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * @author wenhanglei
 */
public class BackspaceStringCompare {
	/*
	 * 思路：
	 */
	public boolean backspaceCompare(String S, String T) {
		return resultStr(S).equals(resultStr(T));
	}
	
	private String resultStr(String s){
		Stack<Character> stack = new Stack<>();
		for(char ch : s.toCharArray()){
			if(ch == '#'){
				if(!stack.isEmpty()) stack.pop();
			}else stack.push(ch);
		}
		String ret = "";
		for(char ch : stack) ret += ch;
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BackspaceStringCompare sol = new BackspaceStringCompare();
		boolean ret = sol.backspaceCompare("xywrrmp","xywrrmu#p");
		System.out.println(ret);
	}
}
