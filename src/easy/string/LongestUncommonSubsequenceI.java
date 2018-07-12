package easy.string;

/**
 * Given a group of two strings, you need to find the longest uncommon
 * subsequence of this group of two strings. The longest uncommon subsequence is
 * defined as the longest subsequence of one of these strings and this
 * subsequence should not be any subsequence of the other strings.
 * 
 * @author wenhanglei
 */
public class LongestUncommonSubsequenceI {
	/*
	 * 思路：
	 */
	public int findLUSlength(String a, String b) {
		return ((a.length() == b.length()) && (a.contains(b) || b.contains(a)))?-1:Math.max(a.length(), b.length());
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LongestUncommonSubsequenceI sol = new LongestUncommonSubsequenceI();
		int ret = sol.findLUSlength("abc", "adc");
		System.out.println(ret);
	}
}
