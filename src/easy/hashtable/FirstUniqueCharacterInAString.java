package easy.hashtable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string, find the first non-repeating character in it 
 * and return it's index. If it doesn't exist, return -1.
 * @author wenhanglei
 */
public class FirstUniqueCharacterInAString {
	/*
	 * 思路：
	 * 不使用队列，遍历两次即可
	 * 第一次保存每个字符出现的频率
	 * 第二次查找一个频率为1的字符即为结果
	 */
	public int firstUniqChar(String s) {
		int[] counts = new int[26];
		for(int i = 0; i < s.length(); i++)
			counts[s.charAt(i) - 'a']++;
		for(int i = 0; i < s.length(); i++)
			if(counts[s.charAt(i)-'a'] == 1) return i;
		return -1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FirstUniqueCharacterInAString sol = new FirstUniqueCharacterInAString();
		int ret = sol.firstUniqChar("loveleetcode");
		System.out.println(ret);
	}
}
