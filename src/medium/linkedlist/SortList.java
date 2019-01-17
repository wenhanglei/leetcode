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
		ListNode helper = new ListNode(-1);
		helper.next = head;
		
		int count = 1;
		ListNode first, second, next, curr, temp;
		while(true){
			curr = helper;
			next = curr.next;
			while(true){
				if(next == null) break;
				first = next;
				second = first;
				for(int i = 0; i < count; i++){
					if(second == null) {
						if(first == helper.next) return helper.next;
						else break;
					}
					if(i == count-1) {
						temp = second.next;
						second.next = null;
						second = temp;
					}else second = second.next;
				}
				next = second;
				for(int i = 0; i < count; i++){
					if(next == null) break;
					if(i == count-1){
						temp = next.next;
						next.next = null;
						next = temp;
					}else next = next.next;
				}
				while(first != null && second != null){
					if(first.val <= second.val){
						curr.next = first;
						first = first.next;
					}else {
						curr.next = second;
						second = second.next;
					}
					curr = curr.next;
				}
				if(first == null){
					curr.next = second;
					while(second.next != null) second = second.next;
					curr = second;
				}else if(second == null){
					curr.next = first;
					while(first.next != null) first = first.next;
					curr = first;
				}
			}
			count <<= 1;
		}
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
