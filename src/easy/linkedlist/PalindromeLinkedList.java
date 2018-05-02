package easy.linkedlist;
/**
 * Given a singly linked list, determine if it is a palindrome.
 * @author wenhanglei
 */
public class PalindromeLinkedList {
	/*
	 * 思路：
	 * 递归
	 */
	public boolean isPalindrome(ListNode head) {
		//定义两个快慢不同的指针
		ListNode slow = head, fast = head;
		while(fast != null){
			if(fast.next == null)break;
			slow = slow.next;
			fast = fast.next.next;
		}
		//反转链表的后半部分
		ListNode right = reverse(slow);
		ListNode left = head;
		while(left != slow){
			if(left.val != right.val) return false;
			right = right.next;
			left = left.next;
		}
		return true;
    }
	
	/**
	 * 翻转前半部分的链表
	 */
	private ListNode reverse(ListNode node){
		if(node == null) return null;
		ListNode sentinel = new ListNode(0);           //哨兵节点
		ListNode curr = node;                          //当前需要处理的节点
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
		
		int[] arr = {4, 3, 2, 2, 3, 4};
		ListNode list = ListUtils.getList(arr);
		PalindromeLinkedList sol = new PalindromeLinkedList();
		boolean res = sol.isPalindrome(list);
		System.out.println(res);
		
	}
}
