package medium.linkedlist;

import java.util.Arrays;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * @author wenhanglei
 */
public class PartitionList {
	/*
	 * 思路：使用两个节点，一个保存小于部分的尾节点一个保存大于等于部分的尾节点
	 */
	public ListNode partition(ListNode head, int x) {
		//边界检查
		if(head == null) return null;
		ListNode pre = null, pro = null, curr = head, proHead = null, preHead = null;
		while(curr != null){
			if(curr.val < x){
				if(pre == null) preHead = curr;
				else if(pre.next != curr) pre.next = curr;
				pre = curr;
			}else {
				if(pro == null) proHead = curr;
				else if(pro.next != curr) pro.next = curr;
				pro = curr;
			}
			curr = curr.next;
		}
		if(pro == null) return preHead;
		if(pre == null) return proHead;
		pro.next = null;
		pre.next = proHead;
		return preHead;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1};
		ListNode head = ListUtils.getList(arr);
		PartitionList sol = new PartitionList();
		ListNode ret = sol.partition(head, 0);
		System.out.println(Arrays.toString(ListUtils.getArray(ret)));
	}
}
