package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * @author wenhanglei
 */
public class WordPattern {
	/*
	 * 思路：
	 */
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		char[] cs = pattern.toCharArray();
		if(cs.length != words.length) return false;
		Map<Character, String> map = new HashMap<>();
		for(int i = 0; i < cs.length; i++){
			String s = map.get(cs[i]);
			if(s == null){
				if(map.containsValue(words[i])) return false;
				map.put(cs[i], words[i]);
			}
			else if(!s.equals(words[i])) return false;
		}
        return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		WordPattern sol = new WordPattern();
		boolean ret = sol.wordPattern("abba", "dog dog dog dog");
		System.out.println(ret);
	}
}
