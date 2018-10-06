package easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;


/**
 * We are given two sentences A and B. (A sentence is a string of space
 * separated words. Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words.
 * 
 * You may return the list in any order.
 * 
 * @author wenhanglei
 */
public class UncommonWordsfromTwoSentences {
	/*
	 * 思路：统计所有的单词返回只出现一次的即为结果
	 */
	public String[] uncommonFromSentences(String A, String B) {
		//边界检查
		if(A == null || B == null) return null;
		HashMap<String, Integer> map = new HashMap<>();
		for(String word : A.split(" ")) map.put(word, map.containsKey(word)?map.get(word)+1:1);
		for(String word : B.split(" ")) map.put(word, map.containsKey(word)?map.get(word)+1:1);
		LinkedList<String> list = new LinkedList<>();
		for(Entry ent : map.entrySet()){
			if((int)ent.getValue() == 1) list.add((String) ent.getKey());
		}
		return list.toArray(new String[list.size()]);
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UncommonWordsfromTwoSentences sol = new UncommonWordsfromTwoSentences();
		String[] ret = sol.uncommonFromSentences("apple apple", "banana");
		System.out.println(Arrays.toString(ret));
	}
}
