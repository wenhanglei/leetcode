package medium.linkedlist;

import utils.ListNode;

/**
 * You are given two non-empty linked lists representing
 * two non-negative integers.
 * The digits are stored in reverse order and
 * each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain
 * any leading zero, except the number 0 itself.
 * @author wenhanglei
 */
public class AddTwoNumbers {
	/*
	 * 思路：
	 * 简单加法器
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		//哨兵结点
		ListNode sentinel = new ListNode(-1);
		ListNode node = sentinel;
		
		int sum = 0;
		while(cur1 != null || cur2 != null){
			sum /= 10;
			
			if(cur1 != null){
				sum += cur1.val;
				cur1 = cur1.next;
			}
			
			if(cur2 != null){
				sum += cur2.val;
				cur2 = cur2.next;
			}
			
			node.next = new ListNode(sum % 10);
			node = node.next;
		}
		if(sum >= 10){
			node.next = new ListNode(1);
		}
		
		return sentinel.next;
    }
}
