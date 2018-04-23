package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * @author wenhanglei
 */
public class IsomorphicStrings {
	/*
	 * 思路：
	 */
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		char[] cs = s.toCharArray();
		char[] ts = t.toCharArray();
		if(cs.length != ts.length) return false;
		for(int i = 0; i < cs.length; i++){
			if(!map.containsKey(cs[i])){
				if(map.containsValue(ts[i])) return false;
				map.put(cs[i], ts[i]);
			}else{
				if(ts[i] != map.get(cs[i])) return false;
			}
		}
        return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		IsomorphicStrings sol = new IsomorphicStrings();
		boolean res = sol.isIsomorphic("ab", "aa");
		System.out.println(res);
	}
}
