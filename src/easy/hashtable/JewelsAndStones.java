package easy.hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * @author wenhanglei
 */
public class JewelsAndStones {
	/*
	 * 思路：使用hashset查找即可
	 */
	public int numJewelsInStones(String J, String S) {
		//边界检查
		if(J == null || S == null) return 0;
		HashSet<Character> set = new HashSet<>();
		for(char c : J.toCharArray()){
			set.add(c);
		}
		int cnt = 0;
		for(char c : S.toCharArray()){
			if(set.contains(c)) cnt++;
		}
		return cnt;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
