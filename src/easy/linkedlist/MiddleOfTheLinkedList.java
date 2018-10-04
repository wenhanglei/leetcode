package easy.linkedlist;

/**
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * @author wenhanglei
 */
public class MiddleOfTheLinkedList {
	/*
	 * 思路：快慢指针即可
	 */
	public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = fast;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{1, 2, 3, 4, 5});
		ListNode head = new ListNode(-1);
		head.next = list;
		MiddleOfTheLinkedList sol = new MiddleOfTheLinkedList();
		ListNode ret = sol.middleNode(head);
		while(ret != null){
			System.out.println(ret.val + " ");
			ret = ret.next;
		}
	}
}
