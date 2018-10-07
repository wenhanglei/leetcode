package easy.array;

import java.util.Arrays;
import java.util.HashSet;


/**
 * Return an integer array ans where ans[0] is the size of the candy bar that
 * Alice must exchange, and ans[1] is the size of the candy bar that Bob must
 * exchange.
 * 
 * @author wenhanglei
 */
public class FairCandySwap {
	/*
	 * 思路：先统计两个数组所有数值的和
	 */
	public int[] fairCandySwap(int[] A, int[] B) {
		int remain = 0;
		for (int i : A) remain += i;
		for (int i : B) remain -= i;
		remain /= 2;
		HashSet<Integer> set = new HashSet<>();
		int[] ret = new int[2];
		if(remain > 0){
			for (int i : A) set.add(i);
			for (int i : B) if(set.contains(i+remain)){
				ret[0] = i+remain;
				ret[1] = i;
			}
		}else{
			for(int i : B) set.add(i);
			for(int i : A) if(set.contains(i-remain)){
				ret[0] = i;
				ret[1] = i-remain;
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] A = {1, 2, 5};
		int[] B = {2, 4};
		FairCandySwap sol = new FairCandySwap();
		int[] ret = sol.fairCandySwap(A, B);
		System.out.println(Arrays.toString(ret));
	}
}
