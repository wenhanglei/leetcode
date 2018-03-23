package easy.math;
/**
 * Given two binary strings, return their sum (also a binary string).
 * @author wenhanglei
 */
public class AddBinary {
	/*
	 * 思路：
	 * 加法器
	 */
	public String addBinary(String a, String b) {
		//边界检查
		if(a == null || b == null) return null;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1, j = b.length()-1, c = 0;
		while(i >= 0 || j >= 0){
			int sum = c;
			sum += i >= 0?a.charAt(i--)-'0':0;
			sum += j >= 0?b.charAt(j--)-'0':0;
			sb.append(sum%2);
			c = sum/2;
		}
		if(c == 1) sb.append('1');
        return sb.reverse().toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String a = "11";
		String b = "10";
		AddBinary sol = new AddBinary();
		String res = sol.addBinary(a, b);
		System.out.println(res);
	}
}
