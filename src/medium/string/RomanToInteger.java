package medium.string;
/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author wenhanglei
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		if(s == "I") return 1;
		if(s == "V") return 5;
		if(s == "X") return 10;
		if(s == "L") return 50;
		if(s == "C") return 100;
		if(s == "D") return 500;
		if(s == "M") return 1000;
		return 0;
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
		
		RomanToInteger sol = new RomanToInteger();
		int romanToInt = sol.romanToInt(s1);
		System.out.println(romanToInt);
		
	}
}
