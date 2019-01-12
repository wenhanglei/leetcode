package medium.linkedlist;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. To represent a cycle in the given linked list, we use an
 * integer pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle in the linked
 * list.
 * 
 * @author wenhanglei
 */
public class LinkedListCycleII {
	/*
	 * 思路：使用快慢双指针即可
	 */
	public ListNode detectCycle(ListNode head) {
		int len = 1;
		if(head == null || head.next == null) return null;
		ListNode fast = head.next.next, slow = head.next;
		while(true){
			if(fast == slow) break;
			if(fast == null || fast.next == null) return null;
			fast = fast.next.next;
			slow = slow.next;
			len++;
		}
		fast = head;
		slow = head;
		for(int i = 0; i < len; i++) fast = fast.next;
		while(slow != fast){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
		
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
