package medium.string;
/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author wenhanglei
 */
public class RomanToInteger {
	/*
	 * 思路：
	 * 计算每一个字符代表的数字之和最后减去特殊情况
	 */
	public int romanToInt(String s) {
		//结果变量
		int sum = 0;
		//先去除异常情况
		if(s.indexOf("IV") != -1) sum -= 2;
		if(s.indexOf("IX") != -1) sum -= 2;
		if(s.indexOf("XL") != -1) sum -= 20;
		if(s.indexOf("XC") != -1) sum -= 20;
		if(s.indexOf("CD") != -1) sum -= 200;
		if(s.indexOf("CM") != -1) sum -= 200;
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++){
			if(chars[i] == 'I') sum += 1;
			if(chars[i] == 'V') sum += 5;
			if(chars[i] == 'X') sum += 10;
			if(chars[i] == 'L') sum += 50;
			if(chars[i] == 'C') sum += 100;
			if(chars[i] == 'D') sum += 500;
			if(chars[i] == 'M') sum += 1000;
		}
		return sum;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String s1 = "I";
		String s2 = "V";
		String s3 = "X";
		String s4 = "L";
		String s5 = "C";
		String s6 = "D";
		String s7 = "M";
		String[] s = {s1, s2, s3, s4, s5, s6, s7};
		
		RomanToInteger sol = new RomanToInteger();
		for(int i = 0; i < s.length; i++){
			int rom = sol.romanToInt(s[i]);
			System.out.println(rom);
		}
		
	}
}
