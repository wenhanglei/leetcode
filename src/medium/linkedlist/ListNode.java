package medium.linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	
	@Override
	public String toString() {
		String str = "";
		ListNode t = this;
		while(t.next != null){
			str += t.val + "->";
			t = t.next;
		}
		str += t.val;
		return str;
	}
}
