package medium.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * @author wenhanglei
 */
public class String2Integer {
	/*
	 * 思路：判断各种情况分别处理即可
	 */
	public int myAtoi(String str) {
		//边界检查
		if(str == null) return 0;
		str = str.trim();
		Pattern p = Pattern.compile("^[+-]?\\d+");
		Matcher m = p.matcher(str);
		if(m.find()){
			try {
				return Integer.parseInt(m.group());
			} catch (NumberFormatException e) {
				if(m.group().startsWith("-")) return Integer.MIN_VALUE;
				else return Integer.MAX_VALUE;
			}
		}
		return 0;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String2Integer sol = new String2Integer();
		int ret = sol.myAtoi("-91283472332");
		System.out.println(ret);
	}
}
