package medium.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * @author wenhanglei
 */
public class WordLadder {
	/*
	 * 思路： 广度优先遍历
	 */
	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		boolean[] marked = new boolean[wordList.size()];
		for(int i = 0; i < wordList.size(); i++){
			if(beginWord.equals(wordList.get(i))) marked[i] = true;
		}
		int count = 1;
		queue.offer(beginWord);
		queue.offer(null);
		while(!queue.isEmpty()){
			String str = queue.poll();
			if(str != null){
				if(str.equals(endWord)) return count;
				for(int i = 0; i < wordList.size(); i++){
					if(!marked[i]){
						String word = wordList.get(i);
						if(isValid(str, word)) {
							marked[i] = true;
							queue.add(word);
						}
					}
				}
			}else {
				count++;
				if(queue.peek() != null) queue.add(null);
			}
			
		}
		return 0;
	}
	
	private boolean isValid(String str1, String str2){
		int count = 0;
		for(int i = 0; i < str1.length(); i++){
			if(count > 1) return false;
			if(str1.charAt(i)-str2.charAt(i) != 0) count++;
		}
		return count == 1?true:false;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "hot";
		List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
		WordLadder sol = new WordLadder();
		int ret = sol.ladderLength(beginWord, endWord, wordList);
		System.out.println(ret);
	}
}
