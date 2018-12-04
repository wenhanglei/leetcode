package medium.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * @author wenhanglei
 */
public class GrayCode {
	/*
	 * 思路：简单的位操作即可
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> list = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		int curr = 0;
		while(set.add(curr)){
			list.add(curr);
			for(int i = 0; i < n; i++){
				int temp = curr^(1<<i);
				if(!set.contains(temp)) {
					curr = temp;
					break;
				}
			}
		}
		return list;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		GrayCode sol = new GrayCode();
		List<Integer> ret = sol.grayCode(3);
		System.out.println(ret);
	}
}
