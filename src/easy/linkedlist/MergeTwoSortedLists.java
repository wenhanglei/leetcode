package easy.linkedlist;

import java.util.Arrays;

import utils.ListNode;
import utils.ListUtils;

/**
 * Merge two sorted linked lists and return it 
 * as a new list. The new list should be made by splicing 
 * together the nodes of the first two lists.
 * @author wenhanglei
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//哨兵节点
		ListNode sentinel = new ListNode(-1);
		ListNode curr = sentinel;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			}else{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		while(l1 != null){
			curr.next = l1;
			curr = curr.next;
			l1 = l1.next;
		}
		while(l2 != null){
			curr.next = l2;
			curr= curr.next;
			l2 = l2.next;
		}
		
        return sentinel.next;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 4};
		int[] arr2 = {1, 3, 4};
		ListNode l1 = ListUtils.getList(arr1);
		ListNode l2 = ListUtils.getList(arr2);
		MergeTwoSortedLists sol = new MergeTwoSortedLists();
		ListNode res = sol.mergeTwoLists(l1, l2);
		Object[] array = ListUtils.getArray(res);
		System.out.println(Arrays.toString(array));
	}
}
