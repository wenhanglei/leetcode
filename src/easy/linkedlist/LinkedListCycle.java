package easy.linkedlist;
/**
 * Given a linked list, determine if it has a cycle in it.
 * @author wenhanglei
 */
public class LinkedListCycle {
	/*
	 * 思路：
	 * 使用两个指针一个步长为1，一个步长为2
	 * 遍历链表直到两个指针指向同一个节点或者其中一个节点为null
	 * 	
	 */
	public boolean hasCycle(ListNode head) {
		//边界判断
		if(head == null || head.next == null) return false;
		//步长为1的节点
		ListNode slow = head.next;
		//步长为2的节点
		ListNode fast = slow.next;
		while(fast != null){
			if(slow == fast) return true;
			fast = fast.next;
			if(fast == null) return false;
			slow = slow.next;
			fast = fast.next;
		}
		return false;
    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
