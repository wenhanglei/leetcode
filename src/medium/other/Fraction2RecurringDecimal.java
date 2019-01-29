package medium.other;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format. If the fractional part is repeating,
 * enclose the repeating part in parentheses.
 * 
 * @author wenhanglei
 */
public class Fraction2RecurringDecimal {
	/*
	 * 思路：使用hashmap和字符串拼接即可
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		if(numerator == 0) return "0";
		int sign = 1;
		if(numerator < 0) {
			numerator = -numerator;
			sign *= -1;
		}
		if(denominator < 0){
			denominator = -denominator;
			sign *= -1;
		}
		if(sign == -1) sb.append('-');
		if(numerator == denominator) return "1";
		else if(numerator > denominator){
			int pre = numerator/denominator;
			numerator = numerator%denominator;
			if(numerator == 0) return Integer.toString(pre);
			sb.append(Integer.toString(pre)+".");
		}else sb.append("0.");
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = sb.length();
		map.put(numerator, count++);
		numerator *= 10;
		sb.append(Integer.toString(numerator/denominator));
		numerator = numerator%denominator;
		if(numerator == 0) return sb.toString();
		while(!map.containsKey(numerator)){
			map.put(numerator, count++);
			numerator *= 10;
			sb.append(Integer.toString(numerator/denominator));
			numerator = numerator%denominator;
			if(numerator == 0) return sb.toString();
		}
		sb.insert((int)map.get(numerator), '(');
		sb.append(')');
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Fraction2RecurringDecimal sol = new Fraction2RecurringDecimal();
		String ret = sol.fractionToDecimal(-1, -2147483648);
		System.out.println(ret);
	}
}
