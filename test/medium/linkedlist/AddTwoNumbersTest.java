package medium.linkedlist;

import java.util.Arrays;

import org.junit.Test;

import utils.ListNode;
import utils.ListUtils;

public class AddTwoNumbersTest {
	
	@Test
	public void testAddTwoNumbers(){
		int[] arr1 = {9};
		int[] arr2 = {9};
		ListNode l1 = ListUtils.getList(arr1);
		ListNode l2 = ListUtils.getList(arr2);
		
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode addTwoNumbers = add.addTwoNumbers(l1, l2);
		System.out.println(Arrays.toString(ListUtils.getArray(addTwoNumbers)));
	}

}
