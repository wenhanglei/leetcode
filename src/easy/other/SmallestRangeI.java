package easy.other;

/**
 * Given an array A of integers, for each integer A[i] we may choose any x with
 * -K <= x <= K, and add x to A[i].
 * 
 * After this process, we have some array B.
 * 
 * Return the smallest possible difference between the maximum value of B and
 * the minimum value of B.
 * 
 * @author wenhanglei
 */
public class SmallestRangeI {
	/*
	 * 思路： 
	 */
	public int smallestRangeI(int[] A, int K) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i = 0; i < A.length; i++){
			max = Math.max(max, A[i]);
			min = Math.min(min, A[i]);
		}
		int ret = max-min-2*K;
		return ret>0?ret:0;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SmallestRangeI sol = new SmallestRangeI();
		int[] A = {0, 10};
		int ret = sol.smallestRangeI(A, 2);
		System.out.println(ret);
	}
}
