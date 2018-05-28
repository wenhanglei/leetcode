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
	 * 队列
	 */
	public int firstUniqChar(String s) {
		int[] counts = new int[26];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(counts[c-96]==0){
				q.offer(i);
			}else if(q.contains(c)) q.remove(c);
			counts[c-96]++;
		}
		if(!q.isEmpty()) return q.poll();
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
