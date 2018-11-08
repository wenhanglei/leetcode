package medium.string;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * @author wenhanglei
 */
public class MultiplyStrings {
	/*
	 * 思路：根据传统的乘法算式计算即可
	 */
	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] retArr = new int[m+n];
		for(int i = m-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				int p1 = i+j, p2 = i+j+1;
				int sum = mul+retArr[p2];
				
				retArr[p1] += sum/10;
				retArr[p2] = sum%10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : retArr) if(!(sb.length()==0 && i == 0)) sb.append(i);
		return sb.length() == 0 ? "0": sb.toString();
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MultiplyStrings sol = new MultiplyStrings();
		String ret = sol.multiply("22451864723456182563452451356845845651254", "352");
		System.out.println(ret);
	}
}
