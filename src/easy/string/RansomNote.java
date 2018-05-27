package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string 
 * containing letters from all the magazines, write a function 
 * that will return true if the ransom note can be constructed 
 * from the magazines ; otherwise, it will return false.
 * @author wenhanglei
 */
public class RansomNote {
	/*
	 * 思路：
	 * 使用map记录magazine中字符出现的次数
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
        	char c = magazine.charAt(i);
        	if(map.get(c)!=null){
        		map.put(c, map.get(c)+1);
        	}else{
        		map.put(c, 1);
        	}
        }
        for(int i = 0; i < ransomNote.length(); i++){
        	char c = ransomNote.charAt(i);
        	if(map.get(c) == null) return false;
        	else if(map.get(c) == 0) return false;
        	else {
        		map.put(c, map.get(c)-1);
        	}
        }
        return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RansomNote sol = new RansomNote();
		boolean ret = sol.canConstruct("aa", "aab");
		System.out.println(ret);
	}
}
