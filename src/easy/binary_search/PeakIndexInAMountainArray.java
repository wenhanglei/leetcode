package easy.binary_search;

/**
 * Let's call an array A a mountain if the following properties hold:
 * 
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] <
 * ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] Given an array that is
 * definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i]
 * > A[i+1] > ... > A[A.length - 1].
 * 
 * @author wenhanglei
 */
public class PeakIndexInAMountainArray {
	/*
	 * 思路：二分查找寻找顶点
	 */
	public int peakIndexInMountainArray(int[] A) {
		int i = 0, j = A.length-1;
		while(i <= j){
			int mid = i + (j-i)/2;
			if(mid == 0 || mid == A.length-1) return mid;
			if(A[mid-1] < A[mid] && A[mid] > A[mid+1]) return mid;
			else if(A[mid-1] < A[mid] && A[mid] < A[mid+1]){
				i = mid + 1;
			}else{
				j = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PeakIndexInAMountainArray sol = new PeakIndexInAMountainArray();
		int[] arr = {0, 2, 1, 0};
		int ret = sol.peakIndexInMountainArray(arr);
		System.out.println(ret);
	}
}
