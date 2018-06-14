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
	 * 滑动窗口
	 */
	public List<Integer> findAnagrams(String s, String p) {
		//结果列表
		List<Integer> list = new LinkedList<>();
		//边界条件
		if(p.length() > s.length()) return list;
		
		char[] a1 = p.toCharArray();
		char[] a2 = s.toCharArray();
		
		//统计模式串中的字符个数
		HashMap<Character, Integer> map = new HashMap<>();
		for(char ch : a1)
			map.put(ch, map.containsKey(ch)?map.get(ch)+1:1);
		
		//定义滑动窗口的起始边界
		int begin = 0, end = 0;
		//字符计数器
		int counter = map.size();
		
		//遍历匹配串
		while(end < a2.length){
			char c = a2[end];
			if(map.containsKey(c)){
				map.put(c, map.get(c)-1);
				if(map.get(c) == 0) counter--;
			}
			end++;
			while(counter == 0){
				char ch = a2[begin];
				if(map.containsKey(ch)){
					map.put(ch, map.get(ch)+1);
					if(map.get(ch) > 0) counter++;
				}
				if(end-begin == a1.length){
					list.add(begin);
				}
				begin++;
			}
		}
		return list;
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
