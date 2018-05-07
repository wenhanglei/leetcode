package easy.sort;
/**
 * Given two strings s and t, write a function to 
 * determine if t is an anagram of s.
 * @author wenhanglei
 */
public class ValidAnagram {
	/*
	 * 思路：
	 * 使用数组保存对应字符的出现次数
	 * 先遍历原字符串统计所有字符的出现次数
	 * 检查生成的字符串是否符合
	 */
	public boolean isAnagram(String s, String t) {
		//边界检查
		if(s.length() != t.length()) return false;
		int[] counts = new int[256];
		int len = s.length();
		for(int i = 0; i < len; i++){
			char c = s.charAt(i);
			counts[c] = counts[c] + 1;
		}
		for(int i = 0; i < len; i++){
			char c = t.charAt(i);
			if(counts[c] == 0) return false;
			counts[c] = counts[c]-1;
		}
		return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String s = "";
		String t ="";
		ValidAnagram sol = new ValidAnagram();
		boolean res = sol.isAnagram(s, t);
		System.out.println(res);
	}
}
