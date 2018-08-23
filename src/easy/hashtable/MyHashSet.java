package easy.hashtable;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * add(value): Insert a value into the HashSet. contains(value) : Return whether
 * the value exists in the HashSet or not. remove(value): Remove a value in the
 * HashSet. If the value does not exist in the HashSet, do nothing.
 * 
 * @author wenhanglei
 */
public class MyHashSet {
	
	private List<Integer>[] listArr;
	private int mod;
	
	/** Initialize your data structure here. */
	public MyHashSet() {
		this.mod = 15;
		listArr = (List<Integer>[]) new LinkedList<?>[mod]; 
	}

	public void add(int key) {
		if(listArr[key%mod] == null)
			listArr[key%mod] = new LinkedList<Integer>();
		if(!contains(key))
			listArr[key%mod].add(key);
	}

	public void remove(int key) {
		if(listArr[key%mod] == null || !contains(key)) return;
		listArr[key%mod].remove((Object)key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		if(listArr[key%mod] == null) return false;
		return listArr[key%mod].contains(key);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		set.contains(1);
		set.contains(3);
		set.add(2);
		set.contains(2);
		set.remove(2);
		set.contains(2);
		
	}
}
