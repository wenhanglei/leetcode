package easy.string;

import java.util.regex.Pattern;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * @author wenhanglei
 */
public class CountBinarySubstrings {
	
	/*
	 * 思路:使用递归
	 */
	public int countBinarySubstrings(String s) {
		//边界检查
		if(s == null) return 0;
		char[] cs = s.toCharArray();
		int cnt = 0;                       //结果变量
		int num = 1;                       //前一个数的重复次数
		int i = 0;
		while(i < cs.length){
			while(i+1 < cs.length && cs[i+1] == cs[i]){
				num++;
				i++;
			}
			if(i == cs.length-1) break;
			int j = i+1;
			while(j+1 < cs.length && cs[j+1] == cs[j]){
				if(j-i==num) break;
				j++;
			}
			cnt += j-i;
			num = 1;
			i++;
		}
		return cnt;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CountBinarySubstrings sol = new CountBinarySubstrings();
		int ret = sol.countBinarySubstrings("0011");
		System.out.println(ret);
	}
}
