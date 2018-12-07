package medium.string;


/**
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * @author wenhanglei
 */
public class DecodeWays {
	
	/*
	 * 思路： 深度优先遍历
	 */
	public int numDecodings(String s) {
		//边界检查
		if(s == null || s.length() == 0) return 0;
		char[] chs = s.toCharArray();
		int curr = 1, pre = 1;
		for(int i = 0; i < chs.length; i++){
			if(chs[i] == '0'){
				if(i == 0 || (chs[i-1] != '1' && chs[i-1] != '2')) return 0;
				int t = curr;
				curr = pre;
				pre = t;
			}else if(i > 0){
				int temp = Integer.parseInt(""+chs[i-1]+chs[i]);
				if(10 < temp && temp <= 26){
					int t = curr;
					curr = curr+pre;
					pre = t;
				}else pre = curr;
			}
		}
		return curr;
	}
	
//	public int numDecodings(String s) {
//		//边界检查
//		if(s == null || s.startsWith("0")) return 0;
//		char[] chs = s.toCharArray();
//		count = 0;
//		helper(chs, 0);
//		return count;
//	}
	
//	private void helper(char[] chs, int i){
//		if(i >= chs.length) {
//			count++;
//			return;
//		}
//		if(chs[i] == '0') return;
//		else {
//			helper(chs, i+1);
//			if(i+1 < chs.length){
//				int t = Integer.parseInt(""+chs[i]+chs[i+1]);
//				if(t < 10 || t > 26) return;
//				helper(chs, i+2);
//			}
//		}
//	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DecodeWays sol = new DecodeWays();
		int ret = sol.numDecodings("24726");
		System.out.println(ret);
	}
}
