package medium.linkedlist;

import java.util.Arrays;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * @author wenhanglei
 */
public class ReverseLinkedListII {
	/*
	 * 思路： 
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		//前半部分最后一个原节点
		ListNode last;
		//逆序后的尾节点
		ListNode tail;
		//最后需要返回的头节点
		ListNode rHead = new ListNode(-1);
		rHead.next = head;
		last = rHead;
		for(int i = 1; i < m; i++) last = last.next;
		tail = last.next;
		for(int i = m; i < n; i++){
			ListNode temp = tail.next;
			tail.next = temp.next;
			temp.next = last.next;
			last.next = temp;
		}
		return rHead.next;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseLinkedListII sol = new ReverseLinkedListII();
		int[] arr = {1, 2, 3, 4, 5};
		ListNode list = ListUtils.getList(arr);
		ListNode ret = sol.reverseBetween(list, 1, 4);
		System.out.println(Arrays.toString(ListUtils.getArray(ret)));
	}
}
