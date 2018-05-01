package easy.stack;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * @author wenhanglei
 */
public class ImplementQueueUsingStacks {
	
	/*
	 * 思路：
	 * 使用两个栈相互倒腾
	 */
	
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	/** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(!s1.isEmpty()){
        	while(!s1.isEmpty())
        		s2.push(s1.pop());
        	s2.push(x);
        	while(!s2.isEmpty())
        		s1.push(s2.pop());
        }else{
        	while(!s2.isEmpty())
        		s1.push(s2.pop());
        	s1.push(x);
        	while(!s1.isEmpty())
        		s2.push(s1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!s1.isEmpty())
        	return s1.pop();
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(!s1.isEmpty())
        	return s1.peek();
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) return true;
        else return false;
    }
}
