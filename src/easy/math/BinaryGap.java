package easy.math;

import java.util.WeakHashMap;

/**
 * Given a positive integer N, find and return the longest distance between two
 * consecutive 1's in the binary representation of N.
 * 
 * If there aren't two consecutive 1's, return 0.
 * 
 * @author wenhanglei
 */
public class BinaryGap {
	/*
	 * 思路：双指针
	 */
	public int binaryGap(int N) {
		int i = -1, j = 0, ret = 0;
		for(; N != 0; j++, N >>= 1){
			if((N&1) == 1) {
				if(i != -1) ret = Math.max(ret, j-i);
				i = j;
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BinaryGap sol = new BinaryGap();
		int ret = sol.binaryGap(8);
		System.out.println(ret);
	}
}
