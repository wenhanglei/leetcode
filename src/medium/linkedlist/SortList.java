package medium.linkedlist;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author wenhanglei
 */
public class SortList {
	/*
	 * 思路：归并排序实现即可
	 */
	public ListNode sortList(ListNode head) {
		//边界检查
		if(head == null || head.next == null) return head;
		//求出链表的长度
		ListNode curr = head;
		int len = 0;
		while(curr != null){
			len++;
			curr = curr.next;
		}
		ListNode helper = new ListNode(-1);
		helper.next = head;
		curr = helper;
		ListNode left, right;
		int count = 1;
		while(true){
			left = helper.next;
			right = left;
			for(int i = 0; i < count; i++) right = right.next;
			while(true){
				ListNode nextLeft = right.next;
				left.next = null;
				right.next = null;
				while(left != null && right != null){
					if(left.val <= right.val){
						curr.next = left;
						left = left.next;
					}else {
						curr.next = right;
						right = right.next;
					}
					curr = curr.next;
				}
				if(left == null){
					curr.next = right;
					while(right.next != null) right = right.next;
					curr = right;
				}else if(right == null){
					curr.next = left;
					while(left.next != null) left = left.next;
					curr = left;
				}
				if(nextLeft == null) break;
				left = nextLeft;
				right = left.next;
			}
			count <<= 1;
			if(count >= len) break;
		}
		return helper.next;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{-1, 5, 3, 4, 0});
		SortList sol = new SortList();
		ListNode ret = sol.sortList(list);
		System.out.println(ret);
	}
}
