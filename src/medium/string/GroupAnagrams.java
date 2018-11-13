package medium.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * @author wenhanglei
 */
public class GroupAnagrams {
	/*
	 * 思路：将当前字符串重排序后保存到map中作为比对的键即可
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ret = new LinkedList<>();
		//边界检查
		if(strs == null || strs.length == 0) return ret;
		HashMap<String, Integer> map = new HashMap<>();
		int idx = 0;
		for(int i = 0; i < strs.length; i++){
			char[] newStr = strs[i].toCharArray();
			Arrays.sort(newStr);
			String str = new String(newStr);
			if(map.containsKey(str)) ret.get(map.get(str)).add(strs[i]);
			else {
				map.put(str, idx++);
				List<String> list = new LinkedList<>();
				list.add(strs[i]);
				ret.add(list);
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		GroupAnagrams sol = new GroupAnagrams();
		List<List<String>> ret = sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(ret);
	}
}
