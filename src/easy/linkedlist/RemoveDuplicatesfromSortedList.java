package easy.linkedlist;

import java.util.Arrays;

/**
 * Given a sorted linked list, delete all duplicates 
 * such that each element appear only once.
 * @author wenhanglei
 */
public class RemoveDuplicatesfromSortedList {
	/*
	 * 思路：
	 * 递归实现
	 */
	public ListNode deleteDuplicates(ListNode head) {
		//边界检查
		if(head == null || head.next == null) return head;
		return delete(head.next, head);
    }
	/**
	 * 对node节点去重并返回去重后的节点
	 */
	private ListNode delete(ListNode curr, ListNode pre){
		if(curr == null) return pre;
		if(curr.val != pre.val){
			pre.next = delete(curr.next, curr);
			return pre;
		}else{
			return delete(curr.next, curr);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 3};
		ListNode list = ListUtils.getList(arr1);
		RemoveDuplicatesfromSortedList sol = new RemoveDuplicatesfromSortedList();
		ListNode res = sol.deleteDuplicates(list);
		Object[] arrRes = ListUtils.getArray(res);
		System.out.println(Arrays.toString(arrRes));
	}
}
