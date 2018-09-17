package easy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * @author wenhanglei
 */
public class MostCommonWord {
	/*
	 * 思路：统计所有的出现次数即可
	 */
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<>();
		for (String str : banned)
			set.add(str);
		HashMap<String, Integer> map = new HashMap<>();
		for (String s : paragraph.split(" ")) {
			String word = toWord(s);
			if (!set.contains(word))
				map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}
		int max = 0;
		for(Integer val : map.values()){
			max = val > max? val: max;
		}
		for(String s : paragraph.split(" ")) {
			String word = toWord(s);
			if(map.containsKey(word) && map.get(word) == max) return word;
		}
		return null;
	}

	private String toWord(String rawStr) {
		String ret = rawStr.toLowerCase();
		if("!?',;.".contains(rawStr.charAt(rawStr.length()-1)+"")){
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MostCommonWord sol = new MostCommonWord();
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String ret = sol.mostCommonWord(paragraph, new String[]{"hit"});
		System.out.println(ret);
	}
}
