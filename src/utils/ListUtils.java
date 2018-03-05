package utils;

import java.util.ArrayList;

/**
 * 链表工具类
 * @author wenhanglei
 */
public class ListUtils {
	
	/**
	 * 根据数组获得相应链表的头结点
	 */
	public static ListNode getList(int[] arr){
		if(arr == null) return null;
		return getList(arr, 0);
	}
	
	public static Object[] getArray(ListNode list){
		ArrayList<Integer> arr = new ArrayList<>();
		while(list != null){
			arr.add(list.val);
			list = list.next;
		}
		return arr.toArray();
	}
	
	private static ListNode getList(int[] arr, int i){
		if(i >= arr.length) return null;
		ListNode node = new ListNode(arr[i]);
		node.next = getList(arr, i+1);
		return node;
	}

}
