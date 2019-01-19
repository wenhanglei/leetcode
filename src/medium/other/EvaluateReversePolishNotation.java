package medium.other;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * @author wenhanglei
 */
public class EvaluateReversePolishNotation {
	/*
	 * 思路： 使用栈完成逆波兰表达式的求解
	 */
	public int evalRPN(String[] tokens) {
		Stack<Integer> operands = new Stack<>();
		for (String t : tokens) {
			if(!"+-*/".contains(t)) operands.push(Integer.parseInt(t));
			else {
				int r = operands.pop();
				int l = operands.pop();
				if(t.equals("+")) operands.push(l+r);
				else if(t.equals("-")) operands.push(l-r);
				else if(t.equals("*")) operands.push(l*r);
				else if(t.equals("/")) operands.push(l/r);
			}
		}
		return operands.pop();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
//		String[] tokens = {"2", "1", "+", "3", "*"};
		EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
		int ret = sol.evalRPN(tokens);
		System.out.println(ret);
	}
}
