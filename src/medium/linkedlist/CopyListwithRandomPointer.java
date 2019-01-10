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
	 * 思路：方案一：使用map保存对应的节点
	 * 方案二：将新生成的节点一次保存到原节点后边最后在分离成新旧两个链表即可
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		//边界检查
		if(head == null) return null;
		//添加新节点
		RandomListNode curr = head;
		while(curr != null){
			RandomListNode node = new RandomListNode(curr.label);
			node.next = curr.next;
			curr.next = node;
			curr = node.next;
		}
		//修改节点的随机连接
		curr = head;
		while(curr != null){
			if(curr.random != null)
				curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		//分离出新的链表
		curr = head;
		RandomListNode rHead = new RandomListNode(-1);
		rHead.next = curr.next;
		RandomListNode nCurr = null;
		while(curr != null){
			nCurr = curr.next;
			curr.next = curr.next.next;
			if(nCurr.next != null)
				nCurr.next = nCurr.next.next;
			curr = curr.next;
		}
		return rHead.next;
		
	}
//	public RandomListNode copyRandomList(RandomListNode head) {
//		//边界检查
//		if(head == null) return null;
//		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//		RandomListNode curr = head;
//		RandomListNode newHead = new RandomListNode(head.label);
//		RandomListNode nCurr = newHead;
//		map.put(head, newHead);
//		while(curr.next != null){
//			RandomListNode node = new RandomListNode(curr.next.label);
//			map.put(curr.next, node);
//			nCurr.next = node;
//			curr = curr.next;
//			nCurr = nCurr.next;
//		}
//		curr = head;
//		nCurr = newHead;
//		while(curr != null){
//			nCurr.random = map.get(curr.random);
//			curr = curr.next;
//			nCurr = nCurr.next;
//		}
//		return newHead;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RandomListNode list = new RandomListNode(-1);
		CopyListwithRandomPointer sol = new CopyListwithRandomPointer();
		RandomListNode ret = sol.copyRandomList(list);
		System.out.println(ret);
	}
}
