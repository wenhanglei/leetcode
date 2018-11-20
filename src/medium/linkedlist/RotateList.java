package medium.linkedlist;

/**
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * @author wenhanglei
 */
public class RotateList {
	/*
	 * 思路：使用间隔为k个节点的两个指针即可
	 */
	public ListNode rotateRight(ListNode head, int k) {
		//边界检查
		if(k == 0 || head == null) return head;
		ListNode first = head, second = head;
		int len = 1;
		//遍历链表获得链表长度
		while((first = first.next) != null) len++;
		first = head;
		k %= len;
		//先移动第一个节点
		for(int i = 0; i < k; i++) first = first.next;
		//同时移动两个节点直到第一个节点到达尾节点
		while(first.next != null){
			first = first.next;
			second = second.next;
		}
		//翻转两个链表即可
		first.next = head;
		head = second.next;
		second.next = null;
		return head;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{0, 1, 2});
		RotateList sol = new RotateList();
		ListNode ret = sol.rotateRight(list, 4);
		System.out.println(ret);
	}
}
