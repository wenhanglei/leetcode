package medium.tree;

import medium.linkedlist.ListNode;
import medium.linkedlist.ListUtils;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST. For this problem, a height-balanced
 * binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 * 
 * @author wenhanglei
 */
public class ConvertSortedList2BinarySearchTree {
	/*
	 * 思路：使用快慢指针找到并保存中间节点和尾节点
	 */
	public TreeNode sortedListToBST(ListNode head) {
		return help(head, null);
		
	}
	
	private TreeNode help(ListNode first, ListNode last){
		if(first == last) return null;
		ListNode fast = first, slow = fast;
		while(fast != last){
			fast = fast.next;
			if(fast == last) break;
			fast = fast.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = help(first, slow);
		node.right = help(slow.next, last);
		return node;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ListNode head = ListUtils.getList(new int[]{-10,-3,0,5,9});
		ConvertSortedList2BinarySearchTree sol = new ConvertSortedList2BinarySearchTree();
		TreeNode ret = sol.sortedListToBST(head);
		System.out.println(ret);
	}
}
