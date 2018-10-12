package easy.array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * @author wenhanglei
 */
public class SortArrayByParity {
	/*
	 * 思路:双指针交换即可
	 */
	public int[] sortArrayByParity(int[] A) {
		for(int i = 0, j = A.length-1;i < j; i++, j--){
			while(i < j && A[i]%2 == 0) i++;
			while(i < j && A[j]%2 != 0) j--;
			int t = A[i];
			A[i] = A[j];
			A[j] = t;
		}
		return A;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] A = {0, 2};
		SortArrayByParity sol = new SortArrayByParity();
		int[] ret = sol.sortArrayByParity(A);
		System.out.println(Arrays.toString(ret));
	}
}
