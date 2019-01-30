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
		Long n = (long) numerator;
		Long d = (long) denominator;
		if(n < 0) {
			n = -n;
			sign *= -1;
		}
		if(d < 0){
			d = -d;
			sign *= -1;
		}
		if(sign == -1) sb.append('-');
		if(n == d) return "1";
		else if(n > d){
			long pre = n/d;
			n = n%d;
			if(n == 0) return Long.toString(pre*sign);
			sb.append(Long.toString(pre)+".");
		}else sb.append("0.");
		HashMap<Long, Integer> map = new HashMap<>();
		int count = sb.length();
		map.put((long)n, count++);
		n = n * 10;
		sb.append(Long.toString(n/d));
		n = n%d;
		if(n == 0) return sb.toString();
		while(!map.containsKey(n)){
			map.put(n, count++);
			n *= 10;
			sb.append(Long.toString(n/d));
			n = n%d;
			if(n == 0) return sb.toString();
		}
		sb.insert((int)map.get(n), '(');
		sb.append(')');
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Fraction2RecurringDecimal sol = new Fraction2RecurringDecimal();
		String ret = sol.fractionToDecimal(-2147483648, 1);
		System.out.println(ret);
	}
}
