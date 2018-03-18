package easy.string;
/**
 * Implement strStr().
 * Return the index of the first occurrence 
 * of needle in haystack, or -1 if needle is not part of haystack.
 * @author wenhanglei
 */
public class ImplementstrStr {
	/*
	 * 思路：
	 * 双指针，一个指针指向字符串文本一个指向匹配文本
	 * 字串查找KMP算法
	 */
	public int strStr(String haystack, String needle) {
		//获得文本字符串的长度
		int N = haystack.length();
		//获得匹配字符串的长度
		int M = needle.length();
		if(N == 0 && M == 0) return 0;
		else if(N != 0 && M != 0){
			if(haystack.equals(needle)) return 0;
			int[][] dfa = new int[256][needle.length()];
			//初始化自动状态机
			dfa(dfa, needle);
			//匹配文本字符串
			int next = 0;
			for(int i = 0; i < N; i++){
				next = dfa[haystack.charAt(i)][next];
				if(next == M) return i - M + 1;
			}
		}else if(M == 0) return 0;
		return -1;
    }
	
	/**使用递归的方式初始化一个自动状态机
	 * @param dfa 确定性有限自动状态机
	 * @param needle 匹配字符串
	 */
	private void dfa(int[][] dfa, String needle){
		//初始化第一列
		dfa[needle.charAt(0)][0] = 1;
		//初始化所有列
		for(int j = 1; j < needle.length(); j++){
			//计算下一列要回退到的列数
			int roll = 0;
			for(int i = 1; i < j; i++)
				roll = dfa[needle.charAt(i)][roll];
			//初始化第j列
			for(int i = 0; i < dfa.length; i++)
				dfa[i][j] = dfa[i][roll];
			dfa[needle.charAt(j)][j] = j+1;
		}
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String HayStack = "";
		ImplementstrStr sol = new ImplementstrStr();
		int res = sol.strStr(HayStack, "");
		System.out.println(res);
	}
}
