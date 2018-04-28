package easy.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * @author wenhanglei
 */
public class ImplementStackusingQueues {
	/*
	 * 思路：
	 * 简单粗暴的使用两个队列的粗暴解法
	 * 
	 */
	
	Queue<Integer> queue;
	
	/** Initialize your data structure here. */
    public ImplementStackusingQueues() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	Queue<Integer> temp = new LinkedList<>();
    	while(!queue.isEmpty()){
    		temp.offer(queue.poll());
    	}
        queue.offer(x);
        while(!temp.isEmpty()){
        	queue.offer(temp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
    
    /**
     * 测试函数
     */
    public static void main(String[] args) {
		ImplementStackusingQueues stack = new ImplementStackusingQueues();
		stack.push(1);
		stack.push(3);
		int sol = stack.pop();
		System.out.println(sol);
		stack.push(2);
		int sol2 = stack.pop();
		System.out.println(sol2);
	}

}
