package easy.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and 
 * retrieving the minimum element in constant time.
 * @author wenhanglei
 */
public class MinStack {
	/*
	 * 思路：
	 * 二叉堆
	 */
	private Stack<Integer> stack;
	private int min = Integer.MAX_VALUE;
	
	/** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<>();
    }
    
    public void push(int x) {
    	if(x <= min){
    		stack.push(min);
    		stack.push(x);
    		min = x;
    	}else{
    		stack.push(x);
    	}
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
    	if(stack.pop() == min){
    		min = stack.pop();
    	}
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return min;
    }
    
//    private boolean less(int a, int b){
//    	return (arr[b]-arr[a])>0;
//    }
//    
//    private void exch(int a, int b){
//    	int temp = arr[a];
//    	arr[a] = arr[b];
//    	arr[b] = temp;
//    }
    
//    private void sink(int i){
//    	if(i==0) return;
//    	while(i*2 <= N){
//	    	int min = i*2;
//	    	if(min < N && less(min+1, min)) min++;
//	    	if(less(i, min)) break;
//	    	exch(i, min);
//	    	i = min;
//    	}
//    }
   
static class Test{
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		int min = minStack.getMin();
		System.out.println(min);
		minStack.pop();
		int min2 = minStack.getMin();
		System.out.println(min2);
	}
}
}

