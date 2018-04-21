package easy.linkedlist;

import java.util.Arrays;

/**
 * Remove all elements from a linked list of integers that have value val.
 * @author wenhanglei
 */
public class RemoveLinkedListElements {
	/*
	 * 思路：
	 * 递归删除
	 */
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		if(head.val == val){
			return removeElements(head.next, val);
		}else{
			head.next = removeElements(head.next, val);
			return head;
		}
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 6, 3, 4, 5, 6};
		ListNode list = ListUtils.getList(arr);
		RemoveLinkedListElements sol = new RemoveLinkedListElements();
		ListNode res = sol.removeElements(list, 6);
		Object[] array = ListUtils.getArray(res);
		System.out.println(Arrays.toString(array));
	}
}
