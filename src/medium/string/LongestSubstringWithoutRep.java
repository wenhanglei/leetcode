package medium.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string, find the length of the 
 * longest substring without repeating characters.
 * @author wenhanglei
 */
public class LongestSubstringWithoutRep {
	/*
	 * 思路：
	 * 队列
	 */
	public int lengthOfLongestSubstring(String s) {
		Deque<Character> queue = new ArrayDeque<>();
		int res = 0;
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++){
			//移除重复的字符
			while(queue.contains(chars[i])){
				queue.removeFirst();
			}
			//添加新字符
			queue.addLast(chars[i]);
			if(queue.size() > res)
				res = queue.size();
		}
        return res;
    }
}
