package easy.linkedlist;

import java.util.Arrays;

/**
 * Reverse a singly linked list.
 * @author wenhanglei
 */
public class ReverseLinkedList {
	/*
	 * 思路：
	 * 循环
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode sentinel = new ListNode(0);           //哨兵节点
		ListNode curr = head;                          //当前需要处理的节点
		ListNode next = curr.next;                     //下一个需要处理的节点
		
		while(curr != null){
			//插入当前节点到哨兵节点之后
			ListNode temp = sentinel.next;
			curr.next = temp;
			sentinel.next = curr;
			
			//修改当前节点
			curr = next;
			if(curr != null)
				next = curr.next;
		}
		return sentinel.next;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 5};
		ListNode list = ListUtils.getList(arr);
		ReverseLinkedList sol = new ReverseLinkedList();
		ListNode res = sol.reverseList(list);
		Object[] array = ListUtils.getArray(res);
		System.out.println(Arrays.toString(array));
		
	}
}
