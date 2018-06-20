package easy.other;

import java.util.Arrays;

/**
 * Your goal is to maximize the number of your content 
 * children and output the maximum number.
 * @author wenhanglei
 */
public class AssignCookies {
	/*
	 * 思路：
	 * 分别对两个数组排序
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0;
		int count = 0;
		while(true){
			if(i == g.length || j == s.length) break;
			if(g[i] <= s[j]) {
				i++;
				count++;
			}
			j++;
		}
		return count;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		AssignCookies sol = new AssignCookies();
		int[] gs = {10, 9, 8, 7};
		int[] s = {5, 6, 7, 8};
		int ret = sol.findContentChildren(gs, s);
		System.out.println(ret);
	}
}
