package easy.other;

/**
 * Design your implementation of the linked list. You can choose to use the
 * singly linked list or the doubly linked list. A node in a singly linked list
 * should have two attributes: val and next. val is the value of the current
 * node, and next is a pointer/reference to the next node. If you want to use
 * the doubly linked list, you will need one more attribute prev to indicate the
 * previous node in the linked list. Assume all nodes in the linked list are
 * 0-indexed.
 * 
 * @author wenhanglei
 */
public class MyLinkedList {
	
	
	private Node first;            //第一个节点
	private Node tail;             //尾节点
	private int size;             //链表的大小
	
	
	
	
	/** Initialize your data structure here. */
	public MyLinkedList() {
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if(checkValid(index))
			return node(index).val;
		else return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list.
	 * After the insertion, the new node will be the first node of the linked
	 * list.
	 */
	public void addAtHead(int val) {
		//获取头结点
		final Node f = first;
		//创建需要添加的节点
		final Node n = new Node(null, val, f);
		first = n;
		if(f == null)
			tail = n;
		else
			f.pre = n;
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		final Node t = tail;
        final Node newNode = new Node(t, val, null);
        tail = newNode;
        if (t == null)
            first = newNode;
        else
            t.next = newNode;
        size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If
	 * index equals to the length of linked list, the node will be appended to
	 * the end of linked list. If index is greater than the length, the node will
	 * not be inserted.
	 */
	public void addAtIndex(int index, int val) {
		if(!(0 <= index && index <= size)) return;
		if(index == size)
			addAtTail(val);
		else{
			final Node succ = node(index);
			final Node pred = succ.pre;
	        final Node newNode = new Node(pred, val, succ);
	        succ.pre = newNode;
	        if (pred == null)
	            first = newNode;
	        else
	            pred.next = newNode;
	        size++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(!checkValid(index)) return;
		Node x = node(index);
		
		final int element = x.val;
        final Node next = x.next;
        final Node pre = x.pre;

        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            x.pre = null;
        }

        if (next == null) {
            tail = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }

        x.val = -1;
        size--;
	}
	
	private boolean checkValid(int index){
		if(0 <= index && index < size) return true;
		else return false;
	}
	
	private Node node(int index){
		if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.pre;
            return x;
        }
	}
	
	/**
	 * 节点内部类
	 * @author wenhanglei
	 */
	static class Node{
		private int val;
		private Node pre;
		private Node next;
		
		public Node(Node pre, int val, Node next) {
			this.pre = pre;
			this.val = val;
			this.next = next;
		}
	}
	
}
