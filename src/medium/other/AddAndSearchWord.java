package medium.other;


/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * @author wenhanglei
 */
public class AddAndSearchWord {
	
	//实现一个字典树即可
	class TrieNode{
		TrieNode[] nodes = new TrieNode[26];
		boolean isWord = false;
	}
	
	TrieNode root = null;
	
	/** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] cs = word.toCharArray();
        TrieNode curr = root;
        for(char ch : cs){
        	if(curr.nodes[ch-'a'] == null){
        		curr.nodes[ch-'a'] = new TrieNode();
        	}
        	curr = curr.nodes[ch-'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word, root);
    }
    
    private boolean search(String str, TrieNode trie){
    	if(str.length() == 0) return trie.isWord;
    	char ch = str.charAt(0);
    	if(ch == '.'){
    		for(TrieNode node : trie.nodes){
    			if(node != null) {
    				if(search(str.substring(1), node)) return true;
    			}
    		}
    		return false;
    	}else{
    		if(trie.nodes[ch-'a'] == null) return false;
    		return search(str.length()==1?"":str.substring(1), trie.nodes[ch-'a']);
    	}
    }
    
    /**
     * 测试函数
     */
    public static void main(String[] args) {
		AddAndSearchWord sol = new AddAndSearchWord();
		sol.addWord("bad");
		sol.addWord("dad");
		sol.addWord("mad");
//		boolean ret = sol.search("pad");
//		boolean ret = sol.search("bad");
//		boolean ret = sol.search(".ad");
		boolean ret = sol.search("b..");
		System.out.println(ret);
	}
}
