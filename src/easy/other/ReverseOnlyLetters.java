package easy.other;

import java.util.Stack;

/**
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their positions.
 * 
 * @author wenhanglei
 */
public class ReverseOnlyLetters {
	/*
	 * 思路：使用栈即可
	 */
	public String reverseOnlyLetters(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < S.length(); i++){
			char ch = S.charAt(i);
			if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')){
				stack.push(ch);
			}
		}
		for(int i = 0; i < S.length(); i++){
			char ch = S.charAt(i);
			if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')){
				sb.append(stack.pop());
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseOnlyLetters sol = new ReverseOnlyLetters();
		String ret = sol.reverseOnlyLetters("Test1ng-Leet=code-Q!");
		System.out.println(ret);
	}
}
