package medium.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * @author wenhanglei
 */
public class SwapNodesPairs {
	/*
	 * 思路：递归调换即可
	 */
	public ListNode swapPairs(ListNode head) {
		if(head == null) return null;
		ListNode t =head.next;
		if(t == null) return head;
		t.next = swapPairs(t.next);
		head.next = t.next;
		t.next = head;
		return t;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{1, 2});
		SwapNodesPairs sol = new SwapNodesPairs();
		ListNode ret = sol.swapPairs(list);
		System.out.println(ret);
	}
}
