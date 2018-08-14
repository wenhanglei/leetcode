package easy.stack;

import java.util.Stack;

/**
 * You're now a baseball game point recorder.
 * 
 * Given a list of strings, each string can be one of the 4 following types:
 * 
 * Integer (one round's score): Directly represents the number of points you get
 * in this round. "+" (one round's score): Represents that the points you get in
 * this round are the sum of the last two valid round's points. "D" (one round's
 * score): Represents that the points you get in this round are the doubled data
 * of the last valid round's points. "C" (an operation, which isn't a round's
 * score): Represents the last valid round's points you get were invalid and
 * should be removed. Each round's operation is permanent and could have an
 * impact on the round before and the round after.
 * 
 * You need to return the sum of the points you could get in all the rounds.
 * 
 * @author wenhanglei
 */
public class BaseballGame {
	/*
	 * 思路：使用栈保存所有的分数记录
	 */
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < ops.length; i++){
			if("+".equals(ops[i])){
				int j = stack.pop();
				int k = j+stack.peek();
				stack.push(j);
				stack.push(k);
			}else if("D".equals(ops[i])){
				stack.push(stack.peek()*2);
			}else if("C".equals(ops[i])){
				stack.pop();
			}else{
				int j = Integer.parseInt(ops[i]);
				stack.push(j);
			}
		}
		int sum = 0;
		for (Integer i : stack) {
			sum += i;
		}
		return sum;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BaseballGame sol = new BaseballGame();
		int ret = sol.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
		System.out.println(ret);
	}

}
