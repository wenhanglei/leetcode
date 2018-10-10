package easy.array;

/**
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 * 
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
 * is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 * Return true if and only if the given array A is monotonic.
 * 
 * @author wenhanglei
 */
public class MonotonicArray {

	/*
	 * 思路:使用两个bool值保存当前序列是否为非递减和非递增序列
	 */
	public boolean isMonotonic(int[] A) {
		boolean inc = true, dec = true;
		for(int i = 1; i < A.length; i++){
			inc &= A[i-1] <= A[i];
			dec &= A[i-1] >= A[i];
		}
		return inc || dec;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MonotonicArray sol = new MonotonicArray();
		int[] A = {1, 2, 3};
		boolean ret = sol.isMonotonic(A);
		System.out.println(ret);
	}

}
