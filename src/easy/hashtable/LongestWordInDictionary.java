package easy.hashtable;


/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string.
 * 
 * @author wenhanglei
 */
public class LongestWordInDictionary {
	
	private String ret = "";
	private StringBuilder sb;
	
	/*
	 * 思路：
	 * 方案一：字典树（有点小复杂，本题就不用了）
	 * 方案二：排序，保存所有合法的字符串
	 */
	public String longestWord(String[] words) {
		//创建字典树的根节点
		TrieNode root = new TrieNode(null);
		TrieNode curr = root;
		//初始化字典树
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < words[i].length(); j++){
				char ch = words[i].charAt(j);
				if(curr.nodes[ch-97] == null)
					curr.nodes[ch-97] = new TrieNode(ch);
				curr = curr.nodes[ch-97];
			}
			if(!curr.isWord) curr.isWord = true;
			curr = root;
		}
		//检索符合条件的结果
		sb = new StringBuilder();
		traverse(root);
		return ret;
	}
	private void traverse(TrieNode node){
		for(TrieNode n : node.nodes){
			if(n != null && n.isWord){
				sb.append(n.val);
				traverse(n);
			}
		}
		if(sb.length() > ret.length()) ret = sb.toString();
		if(sb.length() > 0)sb.deleteCharAt(sb.length()-1);
	}

	
	private class TrieNode{
		private TrieNode[] nodes = new TrieNode[26];
		private Character val;
		private boolean isWord;
		public TrieNode(Character val) {
			this.val = val;
		}
	}
	/*
	 * 方案二：对字符串数组进行排序，保存所有合法的字符串
	 */
//	public String longestWord(String[] words) {
//		Arrays.sort(words);
//		HashSet<String> set = new HashSet<>();
//		String ret = "";
//		for (String str : words) {
//			if(str.length() == 1 || set.contains(str.substring(0, str.length()-1))){
//				ret = str.length() > ret.length() ? str: ret;
//				set.add(str);
//			}
//		}
//		return ret;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestWordInDictionary sol = new LongestWordInDictionary();
		String ret = sol.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
		System.out.println(ret);
	}
}
