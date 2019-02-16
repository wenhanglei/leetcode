package medium.other;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * @author wenhanglei
 */
public class ImplementTrie {
	
	/*
	 * 思路：实现字典树即可
	 */
	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		boolean hasValue = false;
	}
	
	TrieNode root = null;
	
	/** Initialize your data structure here. */
	public ImplementTrie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] cs = word.toCharArray();
		TrieNode curr = root;
		for(char c : cs){
			if(curr.next[c-'a'] == null) curr.next[c-'a'] = new TrieNode();
			curr = curr.next[c-'a'];
		}
		curr.hasValue = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		char[] cs = word.toCharArray();
		TrieNode curr = root;
		for(char c : cs){
			if(curr.next[c-'a'] == null) return false;
			curr = curr.next[c-'a'];
		}
		if(curr.hasValue) return true;
		else return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] cs = prefix.toCharArray();
		TrieNode curr = root;
		for(char c : cs){
			if(curr.next[c-'a'] == null) return false;
			curr = curr.next[c-'a'];
		}
		return true;
	}
	
	public static void main(String[] args) {
		ImplementTrie sol = new ImplementTrie();
		sol.insert("apple");
//		boolean ret = sol.search("apple");
//		boolean ret = sol.search("app");
//		boolean ret = sol.startsWith("app");
		sol.insert("app");
		boolean ret = sol.search("app");
		System.out.println(ret);
	}
}
