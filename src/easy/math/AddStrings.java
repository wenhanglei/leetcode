package easy.math;
/**
 * Given two non-negative integers num1 and num2 
 * represented as string, return the sum of num1 and num2.
 * @author wenhanglei
 */
public class AddStrings {
	/*
	 * 思路：
	 * 遍历逐位相加
	 */
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length();
		int j = num2.length();
		int remain = 0;
		while(i != 0 || j!= 0){
			int sum = 0;
			if(i != 0)
				sum += num1.charAt(--i)-'0';
			if(j != 0)
				sum += num2.charAt(--j)-'0';
			sum += remain;
			sb.append((char)(sum%10+'0'));
			remain = sum/10;
		}
		if(remain == 1) sb.append("1");
        return sb.reverse().toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		AddStrings sol = new AddStrings();
		String ret = sol.addStrings("1", "9");
		System.out.println(ret);
	}
}
