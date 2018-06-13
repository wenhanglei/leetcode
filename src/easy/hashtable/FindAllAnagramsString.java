package easy.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, 
 * find all the start indices of p's anagrams in s.
 * @author wenhanglei
 */
public class FindAllAnagramsString {
	/*
	 * 思路：
	 * 遍历
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new LinkedList<>();
		//边界检查
		if(p.isEmpty()) return list;
		char[] a1 = s.toCharArray();
		char[] a2 = p.toCharArray();
		for(int i = 0; i < a1.length; i++){
			if(hasAnagram(a1, a2, i))
				list.add(i);
		}
		return list;
    }
	
	private boolean hasAnagram(char[] a1, char[] a2, int i){
		//边界检查
		if(a1.length-i < a2.length) return false;
		Map<Character, Integer> map = new HashMap<>();
		for(int j = 0; j < a2.length; j++,i++){
			if(map.containsKey(a1[i]))
				map.put(a1[i], map.get(a1[i])+1);
			else map.put(a1[i], 1);
			if(map.containsKey(a2[j]))
				map.put(a2[j], map.get(a2[j])-1);
			else map.put(a2[j], -1);
		}
		for(Integer j : map.values()){
			if(j != 0) return false;
		}
		return true;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FindAllAnagramsString sol = new FindAllAnagramsString();
		List<Integer> ret = sol.findAnagrams("abab", "ab");
		System.out.println(ret);
		
	}
}
