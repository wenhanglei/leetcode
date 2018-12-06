package medium.string;

/**
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * @author wenhanglei
 */
public class DecodeWays {
	
	int count = 0;
	/*
	 * 思路： 深度优先遍历
	 */
	public int numDecodings(String s) {
		//边界检查
		if(s == null || s.startsWith("0")) return 0;
		char[] chs = s.toCharArray();
		count = 0;
		helper(chs, 0);
		return count;
	}
	
	private void helper(char[] chs, int i){
		if(i >= chs.length) {
			count++;
			return;
		}
		if(chs[i] == '0') return;
		else {
			helper(chs, i+1);
			if(i+1 < chs.length){
				int t = Integer.parseInt(""+chs[i]+chs[i+1]);
				if(t < 10 || t > 26) return;
				helper(chs, i+2);
			}
		}
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DecodeWays sol = new DecodeWays();
		int ret = sol.numDecodings("226");
		System.out.println(ret);
	}
}
