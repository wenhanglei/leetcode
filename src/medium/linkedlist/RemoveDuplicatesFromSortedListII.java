package medium.linkedlist;

import java.util.Arrays;

import medium.array.RemoveDuplicatesfromSortedArrayII;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * @author wenhanglei
 */
public class RemoveDuplicatesFromSortedListII {
	/*
	 * 思路：递归去重即可
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		if(head.val != head.next.val){
			head.next = deleteDuplicates(head.next);
			return head;
		}
		ListNode temp = head;
		while(head != null) {
			head = head.next;
			if(head == null || head.val != temp.val) break;
		}
		return deleteDuplicates(head);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4, 4, 5};
		ListNode head = ListUtils.getList(arr);
		RemoveDuplicatesFromSortedListII sol = new RemoveDuplicatesFromSortedListII();
		head = sol.deleteDuplicates(head);
		System.out.println(Arrays.toString(ListUtils.getArray(head)));
	}
}
