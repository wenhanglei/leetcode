package easy.string;
/**
 * Given an integer n, generate the nth term of 
 * the count-and-say sequence.
 * Note: Each term of the sequence of integers 
 * will be represented as a string.
 * @author wenhanglei
 */
public class CountandSay {
	/*
	 * 思路：
	 * 递归
	 */
	public String countAndSay(int n) {
		if(n <= 0) return "";
		if(n == 1) return "1";
		return next(countAndSay(n-1));
    }
	
	public String next(String pre){
		StringBuilder sb = new StringBuilder();
		char[] arr = pre.toCharArray();
		int count = 1;
		char ch = pre.charAt(0);
		for(int i = 1; i < arr.length; i++, count++){
			if(arr[i] != ch){
				sb.append("" + count + ch);
				count = 0;
				ch = arr[i];
			}
		}
		sb.append("" + count + ch);
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CountandSay sol = new CountandSay();
		String res = sol.countAndSay(6);
		System.out.println(res);
	}
}
