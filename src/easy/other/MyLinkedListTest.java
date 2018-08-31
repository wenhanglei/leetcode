package easy.other;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	
	private MyLinkedList linkedList;
	
	@Before
	public void prepare(){
		linkedList = new MyLinkedList();
	}

	@Test
	public void testGet() {
		int ret = linkedList.get(0);
		System.out.println(ret);
	}

	@Test
	public void testAddAtHead() {
		linkedList.addAtHead(1);
		linkedList.addAtHead(2);
		linkedList.addAtHead(3);
		System.out.println("hah");
	}

	@Test
	public void testAddAtTail() {
		linkedList.addAtTail(3);
		linkedList.addAtTail(2);
		linkedList.addAtTail(1);
		fail("Not yet implemented");
	}

	@Test
	public void testAddAtIndex() {
		linkedList.addAtHead(1);
		linkedList.addAtIndex(1, 2);
	}

	@Test
	public void testDeleteAtIndex() {
		linkedList.deleteAtIndex(1);
	}

}
