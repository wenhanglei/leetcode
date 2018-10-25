package medium.linkedlist;
/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * @author wenhanglei
 */
public class RemoveNthNodeFromEndList {
	/*
	 * 思路：使用两个指针，他们的间隔是n个节点当右边的节点到达尾节点的时候删除前面一个节点即可
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//边界检查
		if(head.next == null && n > 0) return null;
		ListNode pre = head, next = head;
		while(next.next != null){
			if(n == 0) pre = pre.next;
			else n--;
			next = next.next;
		}
		if(n == 1) return pre.next;
		else if(n > 1) return pre;
		else{
			pre.next = pre.next.next;
			return head;
		}
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{1, 2});
		RemoveNthNodeFromEndList sol = new RemoveNthNodeFromEndList();
		ListNode ret = sol.removeNthFromEnd(list, 2);
		System.out.println(ret);
	}

}
