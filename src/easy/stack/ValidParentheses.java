package easy.stack;

import java.util.Stack;


/**
 * Given a string containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if 
 * the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author wenhanglei
 */
public class ValidParentheses {
	/*
	 * 思路：
	 * 栈 后进先出
	 * 碰到左括号入栈，碰到右括号的出栈
	 */
	public boolean isValid(String s) {
		//边界检查
		if(s == null) return false;
		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();
		
		for(int i = 0; i < charArray.length; i++){
			char curr = charArray[i];
			if(curr == '(' || curr == '[' || curr == '{')
				stack.push(curr);
			else if(curr == ')'){
				if(stack.isEmpty() || stack.pop() != '(') return false;
			}else if(curr == ']'){
				if(stack.isEmpty() || stack.pop() != '[') return false;
			}else if(curr == '}'){
				if(stack.isEmpty() || stack.pop() != '{') return false;
			}else
				return false;
		}
		if(stack.isEmpty())
			return true;
		return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String str = "(";
		ValidParentheses sol = new ValidParentheses();
		boolean valid = sol.isValid(str);
		System.out.println(valid);
	}
}
