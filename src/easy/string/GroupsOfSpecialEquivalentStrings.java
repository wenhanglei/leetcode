package easy.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * You are given an array A of strings.
 * 
 * Two strings S and T are special-equivalent if after any number of moves, S ==
 * T.
 * 
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and
 * swapping S[i] with S[j].
 * 
 * Now, a group of special-equivalent strings from A is a non-empty subset S of
 * A such that any string not in S is not special-equivalent with any string in
 * S.
 * 
 * Return the number of groups of special-equivalent strings from A.
 * 
 * @author wenhanglei
 */
public class GroupsOfSpecialEquivalentStrings {
	/*
	 * 思路：使用集合框架统计结果
	 */
	public int numSpecialEquivGroups(String[] A) {
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < A.length; i++){
			if(set.isEmpty()) set.add(A[i]);
			else{
				boolean flag = false;
				for (String str : set) {
					if(specialEquiv(str, A[i])){
						flag = true; break;
					}
				}
				if(!flag) set.add(A[i]);
			}
		}
		return set.size();
	}
	
	private boolean specialEquiv(String A, String B){
		if(A.length() != B.length()) return false;
		HashMap<Character, Integer> oddMap = new HashMap<>();
		HashMap<Character, Integer> ovenMap = new HashMap<>();
		for(int i = 0; i < A.length(); i++){
			char ch = A.charAt(i);
			if(i % 2 == 0){
				ovenMap.put(ch, ovenMap.containsKey(ch)?ovenMap.get(ch)+1:1);
			}else oddMap.put(ch, oddMap.containsKey(ch)?oddMap.get(ch)+1:1);
		}
		for(int i = 0; i < B.length(); i++){
			char ch = B.charAt(i);
			if(i % 2 == 0){
				if(!ovenMap.containsKey(ch)) return false;
				else ovenMap.put(ch, ovenMap.get(ch)-1);
			}else {
				if(!oddMap.containsKey(ch)) return false;
				else oddMap.put(ch, oddMap.get(ch)-1);
			}
		}
		for(int i : ovenMap.values()) if(i != 0) return false;
		for(int i : oddMap.values()) if(i != 0) return false;
		return true;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		GroupsOfSpecialEquivalentStrings sol = new GroupsOfSpecialEquivalentStrings();
		int ret = sol.numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"});
		System.out.println(ret);
	}
}
