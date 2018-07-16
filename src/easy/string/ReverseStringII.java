package easy.string;

/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * @author wenhanglei
 */
public class ReverseStringII {
	/*
	 * 思路： 
	 */
	public String reverseStr(String s, int k) {
		//边界检查
		if(s == null || k <= 1) return s;
		StringBuilder sb = new StringBuilder(s);
		boolean isOdd = false;
		for(int i = 0; i < s.length(); i+=k){
			if(!isOdd){
				int hi = i+k-1;
				reverse(sb, i, (hi>s.length()-1)?s.length()-1:hi);
			}
			isOdd = !isOdd;
		}
		return sb.toString();
	}
	
	private StringBuilder reverse(StringBuilder sb, int lo, int hi){
		while(lo < hi){
			char c = sb.charAt(lo);
			sb.setCharAt(lo, sb.charAt(hi));
			sb.setCharAt(hi, c);
			lo++;
			hi--;
		}
		return sb;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseStringII sol = new ReverseStringII();
		String ret = sol.reverseStr("abcdefg", 2);
		System.out.println(ret);
		
	}
}
