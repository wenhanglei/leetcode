package medium.linkedlist;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * @author wenhanglei
 */
public class ReorderList {
	/*
	 * 思路：首先找到中间节点，将链表分离然后递归换位即可
	 */
	public void reorderList(ListNode head) {
		//边界检查
		if(head == null || head.next == null || head.next.next == null) return ;
		ListNode secon = head;
		ListNode first = head;
		while(first != null && first.next != null){
			first = first.next.next;
			secon = secon.next;
		}
		ListNode temp = secon.next;
		secon.next = null;
		secon = temp;
		ListNode nHead = new ListNode(-1);
		//将第二个链表逆序
		while(secon != null){
			temp = secon.next;
			secon.next = nHead.next;
			nHead.next = secon;
			secon = temp;
		}
		//重新连接两个链表
		first = head;
		while(first != null && nHead.next != null){
			temp = first.next;
			first.next = nHead.next;
			first = temp;
			temp = nHead.next.next;
			nHead.next.next = first;
			nHead.next = temp;
		}
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode list = ListUtils.getList(new int[]{1, 2, 3, 4});
		ReorderList sol = new ReorderList();
		sol.reorderList(list);
		System.out.println(list);
	}
}
