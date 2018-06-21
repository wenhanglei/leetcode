package easy.string;
/**
 * Given a non-empty string check if it can be 
 * constructed by taking a substring of it and 
 * appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase 
 * English letters only and its length will not exceed 10000.
 * @author wenhanglei
 */
public class RepeatedSubstringPattern {
	/*
	 * 思路：
	 * 重复字串的大小必然被输入字串长度除尽
	 * 找到所有可能的字串长度，重复指定次数判断和原字符串是否相同
	 */
	public boolean repeatedSubstringPattern(String s) {
		//边界判断
		if(s == null || s.length() == 0) return false;
		for(int i = 2; i <= s.length(); i++){
			if(s.length()%i==0){
				int end = s.length()/i;
				String temp = s.substring(0, end);
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < i; j++)
					sb.append(temp);
				if(sb.toString().equals(s)) return true;
			}
		}
        return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RepeatedSubstringPattern sol = new RepeatedSubstringPattern();
		boolean ret = sol.repeatedSubstringPattern("abab");
		System.out.println(ret);
	}
}
