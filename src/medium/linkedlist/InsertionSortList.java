package medium.linkedlist;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author wenhanglei
 */
public class InsertionSortList {
	/*
	 * 思路：简单的插入排序实现即可
	 */
	public ListNode insertionSortList(ListNode head) {
		//边界检查
		if(head == null || head.next == null) return head;
		ListNode nHead = new ListNode(-1);
		nHead.next = head;
		ListNode first = nHead;
		ListNode curr = head;
		while(curr.next != null){
			while(first != curr && first.next.val <= curr.next.val){
				first = first.next;
			}
			if(first == curr){
				curr = curr.next;
				first = nHead;
				continue;
			}
			ListNode temp = curr.next;
			curr.next = curr.next.next;
			temp.next = first.next;
			first.next = temp;
			first = nHead;
		}
		return nHead.next;
	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{2});
		InsertionSortList sol = new InsertionSortList();
		ListNode ret = sol.insertionSortList(list);
		System.out.println(ret);
	}
}
