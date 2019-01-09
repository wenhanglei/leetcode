package medium.linkedlist;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author wenhanglei
 */
public class CopyListwithRandomPointer {
	/*
	 * 思路：使用map保存对应的节点
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		//边界检查
		if(head == null) return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode curr = head;
		RandomListNode newHead = curr;
		RandomListNode nCurr = newHead;
		map.put(head, newHead);
		while(curr.next != null){
			RandomListNode node = new RandomListNode(curr.next.label);
			map.put(curr.next, node);
			nCurr.next = node;
			curr = curr.next;
			nCurr = nCurr.next;
		}
		curr = head;
		nCurr = newHead;
		while(curr != null){
			nCurr.random = map.get(curr.random);
			curr = curr.next;
			nCurr = nCurr.next;
		}
		return newHead;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
