package easy.linkedlist;
/**
 * Write a function to delete a node (except the tail) in a singly 
 * linked list, given only access to that node.
 * @author wenhanglei
 */
public class DeleteNodeInALinkedList {
	/*
	 * 思路：
	 * 因为无法取得前继节点，所以需要复制后继节点的值在删除后继节点
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
