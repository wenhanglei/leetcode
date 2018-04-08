package easy.linkedlist;
/**
 * Write a program to find the node at which the 
 * intersection of two singly linked lists begins.
 * @author wenhanglei
 */
public class IntersectionOfTwoLinkedLists {
	/*
	 * 思路：
	 * 分别遍历两个链表获得链表的长度len
	 * 长链表先移动len个节点然后两个链表同时移动直到相遇
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode n1 = headA;
		ListNode n2 = headB;
		int len1 = 0;
		int len2 = 0;
		while(n1 != null){
			len1++;
			n1 = n1.next;
		}
		while(n2 != null){
			len2++;
			n2 = n2.next;
		}
		if(len1 > len2){
			for(int i = 0; i < len1-len2; i++){
				headA = headA.next;
			}
		}else{
			for(int i = 0; i < len2-len1; i++){
				headB = headB.next;
			}
		}
		while(headA != null && headB != null){
			if(headA == headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
        return null;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
